<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<head>
    <title>Meu Cadastro</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Meus Dados</h2>

    <p><strong>Nome:</strong> <%= usuario.getNome() %></p>
    <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
    <p><strong>Telefone:</strong> <%= usuario.getCelular() %></p>
    <p><strong>CPF:</strong> <%= usuario.getCpf() %></p>

    <%-- Botões --%>
    <a href="editar_cadastro.jsp" class="button">Editar meus dados</a>
    <a href="paciente_dashboard.jsp" class="button">Voltar ao Dashboard</a>
</div>

</body>
</html>
