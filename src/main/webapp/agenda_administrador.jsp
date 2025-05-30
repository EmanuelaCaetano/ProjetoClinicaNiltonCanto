<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mack.clinica.model.Consulta" %>

<%
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
    <title>Agenda Administrador</title>
    <link rel="stylesheet" href="css/navBar.css">
    <link rel="stylesheet" href="css/agenda.css">
</head>
<body>
    <div class="navbar">
        <div class="nav-links">
            <a href="admin_dashboard">Home</a>
            <a href="cadastrarPaciente">Cadastrar Paciente</a>
            <a href="cadastro_medico">Cadastro de Médicos</a>
            <a href="agenda_administrador">Consultar Agenda</a>
            <a href="ficha_clinica.jsp">Acessar Ficha Clínica</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <h2>Agenda - Todas as Consultas</h2>
<div class="spacer">
    <form method="get" action="agenda_administrador" >
        <label>Médico:</label>
<select name="medico">
    <option value="">Todos</option>
    <%
        List<String> nomesMedicos = (List<String>) request.getAttribute("nomesMedicos");
        String medicoSelecionado = request.getParameter("medico");
        if (nomesMedicos != null) {
            for (String nome : nomesMedicos) {
    %>
        <option value="<%= nome %>" <%= nome.equals(medicoSelecionado) ? "selected" : "" %>><%= nome %></option>
    <%
            }
        }
        out.println("Nomes encontrados: " + nomesMedicos);
    %>
</select>


        <label>Paciente:</label>
        <input type="text" name="paciente" value="<%= request.getParameter("paciente") != null ? request.getParameter("paciente") : "" %>" />

        <label>Data:</label>
        <input type="date" name="data" value="<%= request.getParameter("data") != null ? request.getParameter("data") : "" %>" />

        <input type="submit" value="Filtrar" />
    </form>
</div>
    <table border="1">
        <tr>
            <th>Data</th>
            <th>Hora</th>
            <th>Médico</th>
            <th>Paciente</th>
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
            <td><%= c.getPacienteNome() %></td>
            <td><%= c.getStatus() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">Nenhuma consulta encontrada.</td></tr>
        <%
            }
        %>
    </table>

</body>
</html>
