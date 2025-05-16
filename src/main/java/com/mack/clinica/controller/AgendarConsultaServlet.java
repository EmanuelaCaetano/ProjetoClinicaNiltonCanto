package com.mack.clinica.controller;

import java.io.IOException;
import java.util.List;

import com.mack.clinica.model.AgendarConsultaDAO;
import com.mack.clinica.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/agendarConsulta")
public class AgendarConsultaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Instancia o DAO com o contexto para conectar ao banco
        AgendarConsultaDAO dao = new AgendarConsultaDAO(getServletContext());

        // Busca a lista de médicos
        List<Usuario> medicos = dao.listarMedicos();
        System.out.println("Médicos encontrados: " + (medicos != null ? medicos.size() : 0));

        // Atribui a lista no request para o JSP usar
        request.setAttribute("medicos", medicos);

        // Encaminha para a página de agendamento
        request.getRequestDispatcher("/agendar_consulta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Pega os dados do formulário
            int profissionalId = Integer.parseInt(request.getParameter("profissionalId"));
            String dataHora = request.getParameter("dataHora");

            // Pega o usuário da sessão
            HttpSession session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");

            if (usuario == null || !"paciente".equals(usuario.getTipo())) {
                System.out.println("Paciente não autenticado. Redirecionando para login.");
                response.sendRedirect("index.jsp");
                return;
            }

            int pacienteId = usuario.getId();

            System.out.println("Paciente ID: " + pacienteId);
            System.out.println("Profissional ID: " + profissionalId);
            System.out.println("Data e Hora: " + dataHora);

            // Instancia DAO
            AgendarConsultaDAO dao = new AgendarConsultaDAO(getServletContext());

            // Agenda a consulta
            boolean sucesso = dao.agendarConsulta(pacienteId, profissionalId, dataHora);
            System.out.println("Sucesso: " + sucesso);

            if (sucesso) {
                response.sendRedirect("mensagem_sucesso.jsp");
            } else {
                response.sendRedirect("index.jsp?erro=agendar");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("paciente_dashboard.jsp?msg=erro");
        }
    }
}
