package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cadastrar_paciente")
public class CadastrarPacienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String celular = request.getParameter("celular");
        String senha = request.getParameter("senha");

        Usuario paciente = new Usuario();
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setCpf(cpf);
        paciente.setCelular(celular);
        paciente.setSenha(senha);
        paciente.setTipo("paciente");

        String path = request.getServletContext().getRealPath("/");
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrarPaciente(paciente, path);

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Encaminha para o JSP com o formulário
        request.getRequestDispatcher("/cadastrar_paciente.jsp").forward(request, response);
    }
}
