package com.mack.clinica.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mack.clinica.model.Usuario;


@WebServlet("/meuCadastro")
public class VisualizarDadosPacienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //verifica se o usuario esta logado e salva em variavel:
        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

        // só volta para o login se não estiver logado
        if (usuarioLogado == null) {
            response.sendRedirect("login");
            return;
        }

        // Redireciona para o JSP
        request.setAttribute("usuario", usuarioLogado);
        request.getRequestDispatcher("/meu_cadastro.jsp").forward(request, response);
    }
}