package com.mack.clinica.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mack.clinica.model.Paciente;
import com.mack.clinica.model.PacienteDAO;
import com.mack.clinica.util.ConexaoBD; // Supondo que você tenha uma classe para conexão com o BD

@WebServlet("/visualizarDadosPaciente")
public class VisualizarDadosPacienteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer pacienteId = (Integer) session.getAttribute("usuarioId"); // Obtenha o ID da sessão

        if (pacienteId != null) {
            Connection conexao = ConexaoBD.getConexao(); // Obtenha a conexão com o BD
            PacienteDAO pacienteDAO = new PacienteDAO(conexao);

            try {
                Paciente paciente = pacienteDAO.buscarPorId(pacienteId);
                if (paciente != null) {
                    request.setAttribute("paciente", paciente); // Armazena o paciente no request
                    request.getRequestDispatcher("visualizar_dados_paciente.jsp").forward(request, response); // Encaminha para a JSP
                } else {
                    // Tratar o caso em que o paciente não foi encontrado (ex: exibir uma mensagem de erro)
                    request.setAttribute("mensagem", "Paciente não encontrado.");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Tratar erros de banco de dados (ex: exibir uma mensagem de erro)
                request.setAttribute("mensagem", "Erro ao acessar o banco de dados.");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            } finally {
                try { if (conexao != null) conexao.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        } else {
            // Tratar o caso em que o usuário não está logado (ex: redirecionar para a página de login)
            response.sendRedirect("login.jsp");
        }
    }
}