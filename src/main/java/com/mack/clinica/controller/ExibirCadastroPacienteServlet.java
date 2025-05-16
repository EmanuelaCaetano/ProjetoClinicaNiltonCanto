package com.mack.clinica.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exibirCadastroPaciente") // Mapeie para a URL do seu link
public class ExibirCadastroPacienteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Encaminha a requisição para a página JSP que contém o formulário de cadastro
        request.getRequestDispatcher("/WEB-INF/cadastrar_paciente.jsp").forward(request, response);
    }
}