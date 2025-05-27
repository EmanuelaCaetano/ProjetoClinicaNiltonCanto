package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editarCadastro")
public class EditarCadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            response.sendRedirect("login");
            return;
        }

        request.setAttribute("usuario", usuarioLogado);
        request.getRequestDispatcher("/editar_cadastro.jsp").forward(request, response);
    }
}
