package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.mack.clinica.model.UsuarioDAO;


@WebServlet("/ficha_clinica")
public class FichaClinicaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        if (usuario == null) {
            response.sendRedirect("login");
            return;
        }

        List<Usuario> pacientes = UsuarioDAO.listarPacientes(getServletContext().getRealPath("/"));
        request.setAttribute("pacientes", pacientes);
        request.getRequestDispatcher("ficha_clinica.jsp").forward(request, response);
    }
}