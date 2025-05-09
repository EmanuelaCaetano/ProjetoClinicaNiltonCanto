<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mack.clinica.model.Paciente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dados do Paciente</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Dados do Paciente</h1>
        <% Paciente paciente = (Paciente) request.getAttribute("paciente"); %>
        <% if (paciente != null) { %>
            <p><strong>Nome:</strong> <%= paciente.getNome() %></p>
            <p><strong>Email:</strong> <%= paciente.getEmail() %></p>
            <p><strong>CPF:</strong> <%= paciente.getCpf() %></p>
            <p><strong>Celular:</strong> <%= paciente.getCelular() %></p>
            <% } else { %>
            <p>Nenhum dado encontrado.</p>
        <% } %>
        <a href="paciente_dashboard.jsp" class="button">Voltar ao Dashboard</a>
    </div>
</body>
</html>