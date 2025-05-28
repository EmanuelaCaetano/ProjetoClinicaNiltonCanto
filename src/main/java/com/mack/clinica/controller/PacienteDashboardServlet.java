package com.mack.clinica.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/paciente_dashboard")
public class PacienteDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //verifica se ha e qual é o usuario logado
        Object usuario = request.getSession().getAttribute("usuarioLogado");

        if (usuario == null || !"paciente".equalsIgnoreCase(((com.mack.clinica.model.Usuario) usuario).getTipo())) {
            response.sendRedirect("login");
            return;
        }
        
        request.getRequestDispatcher("/paciente_dashboard.jsp").forward(request, response);
    }
}

