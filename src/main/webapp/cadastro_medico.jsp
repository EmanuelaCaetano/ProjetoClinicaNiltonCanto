<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Médico</title>
</head>
<body>
    <h2>Cadastrar Novo Médico</h2>
    <form method="post" action="cadastro_medico">
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
    <a href="paciente_dashboard">Voltar ao Dashboard</a>
</body>
</html>
