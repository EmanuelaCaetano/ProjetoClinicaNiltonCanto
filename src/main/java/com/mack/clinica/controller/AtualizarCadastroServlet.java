package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/atualizarCadastro")
public class AtualizarCadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            response.sendRedirect("login");
            return;
        }

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String senha = request.getParameter("senha");
        
        //variavel para não perder o tipo do usuario
        String tipoOriginal = usuarioLogado.getTipo();
        // Atualizar dados do objeto
        usuarioLogado.setNome(nome);
        usuarioLogado.setEmail(email);
        usuarioLogado.setCelular(celular);
        if (senha != null && !senha.trim().isEmpty()) {
            usuarioLogado.setSenha(senha); // Lembre-se: ideal seria usar hash
        }

        // Garante que o tipo não será alterado ou perdido
        usuarioLogado.setTipo(tipoOriginal);

        String realPath = request.getServletContext().getRealPath("/");

        boolean atualizado = UsuarioDAO.atualizarUsuario(usuarioLogado, realPath);

        if (atualizado) {
            request.getSession().setAttribute("usuarioLogado", usuarioLogado);
            response.sendRedirect("meuCadastro");
        } else {
            request.setAttribute("erro", "Erro ao atualizar. Tente novamente.");
            request.getRequestDispatcher("/editar_cadastro.jsp").forward(request, response);
        }
    }
}
