<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mack.clinica.model.Consulta" %>

<%
    // Não é necessário declarar a variável session aqui, pois já existe implicitamente.
    if (session == null || session.getAttribute("nome") == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    List<Consulta> consultas = (List<Consulta>) request.getAttribute("consultas");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Minha Agenda</title>
    <link rel="stylesheet" href="css/agenda.css">
    <link rel="stylesheet" href="css/navBar.css">
</head>
<body>
    <div class="navbar">
        <div class="nav-links">
            <a href="paciente_dashboard">Home</a>
            <a href="agendarConsulta">Agendamento de Consultas</a>
            <a href="minhaAgenda">Minha Agenda</a>
            <a href="meuCadastro">Meu Cadastro</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <h2>Suas Consultas Agendadas</h2>

    <table border="1">
        <tr>
            <th>Data</th>
            <th>Hora</th>
            <th>Médico</th>
            <th>Status</th>
        </tr>
        <%
            if (consultas != null && !consultas.isEmpty()) {
                for (Consulta c : consultas) {
        %>
        <tr>
            <td><%= c.getData() %></td>
            <td><%= c.getHorario() %></td>
            <td><%= c.getMedico() %></td>
            <td><%= c.getStatus() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="4">Nenhuma consulta agendada.</td></tr>
        <%
            }
        %>
    </table>

</body>
</html>
