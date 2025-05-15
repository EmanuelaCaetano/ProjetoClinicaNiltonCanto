package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/cadastro_medico")
public class CadastroMedicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cadastro_medico.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String basePath = request.getServletContext().getRealPath("/");
        UsuarioDAO dao = new UsuarioDAO();

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String celular = request.getParameter("celular");
        String senha = request.getParameter("senha");

        Usuario medico = new Usuario();
        medico.setNome(nome);
        medico.setEmail(email);
        medico.setCpf(cpf);
        medico.setCelular(celular);
        medico.setSenha(senha);
        medico.setTipo("medico");

        dao.cadastrarMedico(medico, basePath);

        response.sendRedirect("admin_dashboard.jsp");
    }
}
