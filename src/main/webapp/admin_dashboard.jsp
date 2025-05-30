<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Painel do Administrador</title>
    <!-- Importa o CSS externo -->
    <link rel="stylesheet" href="css/navBar.css">
    <link rel="stylesheet" href="css/adminDash.css">
</head>
<body>

    <!-- Menu de Navegação  - "botões" -->
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


    
</body>
</html>

