package com.mack.clinica.controller;

import com.mack.clinica.model.Consulta;
import com.mack.clinica.model.ConsultaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/minhaAgenda")
public class MinhaAgendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect("");
            return;
        }

        int pacienteId = (int) session.getAttribute("id");
        String basePath = request.getServletContext().getRealPath("/");
        ConsultaDAO dao = new ConsultaDAO(basePath);

        List<Consulta> consultas = dao.listarPorPaciente(pacienteId);
        

        request.setAttribute("consultas", consultas);
        request.getRequestDispatcher("minha_agenda.jsp").forward(request, response);
    }
}

