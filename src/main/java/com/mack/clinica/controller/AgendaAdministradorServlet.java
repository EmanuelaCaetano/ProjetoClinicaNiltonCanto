package com.mack.clinica.controller;

import com.mack.clinica.model.Consulta;
import com.mack.clinica.model.ConsultaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/agenda_administrador")
public class AgendaAdministradorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String basePath = request.getServletContext().getRealPath("/");
        ConsultaDAO dao = new ConsultaDAO(basePath);

        String medico = request.getParameter("medico");
        String paciente = request.getParameter("paciente");
        String data = request.getParameter("data");

        List<Consulta> consultas = dao.listarTodasComFiltros(medico, paciente, data);
        List<String> nomesMedicos = dao.listarNomesMedicos();

        // Atributos definidos antes do forward
        request.setAttribute("consultas", consultas);
        request.setAttribute("nomesMedicos", nomesMedicos);

        // Agora sim faz o forward para o JSP
        request.getRequestDispatcher("agenda_administrador.jsp").forward(request, response);
    }
}

