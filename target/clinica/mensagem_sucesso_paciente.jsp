<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Paciente</title>
    <script>
        window.onload = function() {
            alert("Paciente cadastrado com sucesso!"); // Mensagem de sucesso do cadastro
            // Depois que o usuário clicar em OK, redireciona para o painel (ou outra página)
            window.location.href = "${pageContext.request.contextPath}/paciente_dashboard.jsp"; // Use o contexto para redirecionar corretamente
        };
    </script>
</head>
<body>
</body>
</html>