<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Paciente</title>
</head>
<body>
    <h1>Cadastro de Paciente</h1>
    <form action="cadastrarPaciente" method="post">
        <div>
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>
        </div>
        <br>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <br>
        <div>
            <label for="celular">Celular:</label>
            <input type="text" id="celular" name="celular">
        </div>
        <br>
        <button type="submit">Cadastrar</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/">Voltar para a página inicial</a>
</body>
</html>