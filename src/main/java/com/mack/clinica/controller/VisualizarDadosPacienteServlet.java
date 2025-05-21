package com.mack.clinica.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/meuCadastro")
public class VisualizarDadosPacienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Verifica se há usuário logado
        if (request.getSession().getAttribute("usuarioLogado") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Redireciona para o JSP
        request.getRequestDispatcher("meu_cadastro.jsp").forward(request, response);
    }
}

