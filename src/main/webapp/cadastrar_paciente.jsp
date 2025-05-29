<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Paciente</title>
</head>
<body>
    <h2>Cadastro de Paciente</h2>
    <form method="post" action="cadastrar_paciente">

        <!-- Mesmos campos do cadastro do medico -->

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
        <input type="submit" value="Cadastrar Paciente">
    </form>
    <a class="button" href="admin_dashboard">Voltar ao Dashboard</a>
    
</body>
</html>
