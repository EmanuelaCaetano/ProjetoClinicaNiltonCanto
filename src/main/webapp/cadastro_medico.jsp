<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Médico</title>
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
            <a href="ficha_clinica.jsp">Acessar Ficha Clínica</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <h2>Cadastrar Novo Médico</h2>
    <form method="post" action="cadastro_medico" class="spacer">
        <label>Nome:</label>
        <input type="text" name="nome" required><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <label>CPF:</label>
        <input type="text" name="cpf" required><br>

        <label>Celular:</label>
        <input type="text" name="celular" required><br>

        <label>Senha:</label>
        <input type="password" name="senha" required><br>

        <input type="submit" value="Cadastrar Médico">
    </form>

</body>
</html>
