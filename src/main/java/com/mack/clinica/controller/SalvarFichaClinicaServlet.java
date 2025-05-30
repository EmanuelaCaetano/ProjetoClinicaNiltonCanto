package com.mack.clinica.controller;

import com.mack.clinica.model.Prontuario;
import com.mack.clinica.model.ProntuarioDAO;
import com.mack.clinica.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/salvarFichaClinica")
public class SalvarFichaClinicaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        if (usuario == null) {
            response.sendRedirect("login");
            return;
        }

        int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
        int profissionalId = usuario.getId();  // supondo que o profissional é o usuário logado
        String data = request.getParameter("data");
        String anotacoes = request.getParameter("anotacoes");
        String prescricoes = request.getParameter("prescricoes");

        Prontuario prontuario = new Prontuario();
        prontuario.setPacienteId(pacienteId);
        prontuario.setProfissionalId(profissionalId);
        prontuario.setData(data != null ? data : LocalDate.now().toString());
        prontuario.setAnotacoesMedicas(anotacoes);
        prontuario.setPrescricoes(prescricoes);

        String path = request.getServletContext().getRealPath("/");
        ProntuarioDAO dao = new ProntuarioDAO();
        boolean salvo = dao.salvarProntuario(prontuario, path);

        if (salvo) {
            request.setAttribute("mensagem", "Ficha salva com sucesso!");
        } else {
            request.setAttribute("mensagem", "Erro ao salvar a ficha.");
        }

        request.getRequestDispatcher("ficha_clinica.jsp").forward(request, response);
    }
}
