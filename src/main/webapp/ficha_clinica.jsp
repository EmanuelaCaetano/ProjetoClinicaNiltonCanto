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
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Ficha Clínica</h2>

    <form method="post" action="salvarFichaClinica">
        <label>Paciente:</label>
        <input type="text" name="paciente" value="<%= usuario.getNome() %>" readonly />

        <label>Observações Médicas:</label>
        <textarea name="observacoes" rows="6" placeholder="Descreva as informações médicas..."></textarea>

        <button type="submit" class="button">Salvar</button>
    </form>
    
    <a href="admin_dashboard.jsp" class="button">Voltar ao Dashboard</a>
</div>
</body>
</html>
