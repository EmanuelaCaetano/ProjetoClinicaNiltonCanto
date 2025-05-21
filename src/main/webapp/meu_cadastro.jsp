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
</head>
<body>
    <h2>Meus Dados</h2>
    <p><strong>Nome:</strong> <%= usuario.getNome() %></p>
    <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
    <p><strong>Telefone:</strong> <%= usuario.getCelular() %></p>
    <p><strong>CPF:</strong> <%= usuario.getCpf() %></p>
</body>
</html>
