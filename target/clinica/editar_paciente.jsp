<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="com.mack.clinica.model.Paciente" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Editar Paciente</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <h1>Editar Paciente</h1>
        <% Paciente paciente = (Paciente) request.getAttribute("paciente");
           if (paciente != null) { %>
            <form action="PacienteController?acao=atualizar" method="post">
                <input type="hidden" name="id" value="<%= paciente.getId() %>">
                Nome: <input type="text" name="nome" value="<%= paciente.getNome() %>" required><br>
                Email: <input type="email" name="email" value="<%= paciente.getEmail() %>" required><br>
                CPF: <input type="text" name="cpf" value="<%= paciente.getCpf() %>" required><br>
                Celular: <input type="text" name="celular" value="<%= paciente.getCelular() %>" required><br>
                Senha: <input type="password" name="senha" value="<%= paciente.getSenha() %>" required><br>
                <input type="submit" value="Atualizar">
            </form>
        <% } %>
        <a href="admin_dashboard.jsp">Voltar ao Dashboard</a>
    </body>
    </html>