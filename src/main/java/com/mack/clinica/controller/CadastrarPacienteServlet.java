    package com.mack.clinica.controller;

    import com.mack.clinica.model.Paciente;
    import com.mack.clinica.model.PacienteDAO;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import java.io.IOException;

    @WebServlet("/cadastrarPaciente")
    public class CadastrarPacienteServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Paciente paciente = new Paciente();
            paciente.setNome(request.getParameter("nome"));
            paciente.setEmail(request.getParameter("email"));
            paciente.setCelular(request.getParameter("celular"));

            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.cadastrarPaciente(paciente);

            response.sendRedirect("mensagem_sucesso_paciente.jsp");
        }
    }
    