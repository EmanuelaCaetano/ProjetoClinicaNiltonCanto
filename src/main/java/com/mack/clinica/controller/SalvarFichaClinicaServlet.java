package com.mack.clinica.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/salvarFichaClinica")
public class SalvarFichaClinicaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Por enquanto, só simula o salvamento
        String paciente = request.getParameter("paciente");
        String observacoes = request.getParameter("observacoes");

        System.out.println("Ficha de " + paciente + ": " + observacoes);

        // Redireciona com mensagem (melhorar depois, caso dê tempo)
        request.setAttribute("mensagem", "Ficha salva com sucesso!");
        request.getRequestDispatcher("ficha_clinica.jsp").forward(request, response);
    }
}
