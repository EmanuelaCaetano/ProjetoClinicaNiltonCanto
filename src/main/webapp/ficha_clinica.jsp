<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Ficha Clínica</title>
    <link rel="stylesheet" href="css/navBar.css">
    <link rel="stylesheet" href="css/agenda.css">
</head>
<body>
    <div class="navbar">
        <div class="nav-links">
            <a href="admin_dashboard">Home</a>
            <a href="cadastrar_paciente">Cadastrar Paciente</a>
            <a href="cadastro_medico">Cadastro de Médicos</a>
            <a href="agenda_administrador">Consultar Agenda</a>
            <a href="ficha_clinica">Acessar Ficha Clínica</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <div class="container">
        <h2>Ficha Clínica</h2>

        <form method="post" action="salvarFichaClinica">
            <label>Paciente:</label>
            <input type="hidden" name="pacienteId" value="<%= usuario.getId() %>" />
            <p><strong>Paciente:</strong> <%= usuario.getNome() %></p>


            <label>Data:</label>
            <input type="date" name="data" required />

            <label>Anotações:</label>
            <textarea name="anotacoes" rows="4"></textarea>

            <label>Prescrições:</label>
            <textarea name="prescricoes" rows="4"></textarea>

            <button type="submit" class="button">Salvar</button>
        </form>

        <% if (request.getAttribute("mensagem") != null) { %>
            <p><%= request.getAttribute("mensagem") %></p>
        <% } %>
    </div>
</body>
</html>