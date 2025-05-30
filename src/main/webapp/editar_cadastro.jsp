<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    // Garante que o usuário esteja logado
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
    if (usuario == null) {
        response.sendRedirect("index.jsp"); // Redireciona para a página de login se não houver usuário
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Editar Meu Cadastro</title>
    <link rel="stylesheet" href="css/navBar.css"> <%-- Inclua seu CSS --%>
    <link rel="stylesheet" href="css/agenda.css"> <%-- Inclua seu CSS --%>
    

</head>
<body>

    <div class="navbar">
        <div class="nav-links">
            <a href="paciente_dashboard">Home</a>
            <a href="agendarConsulta">Agendamento de Consultas</a>
            <a href="minhaAgenda">Minha Agenda</a>
            <a href="meuCadastro">Meu Cadastro</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <div class="content">
        <h1>Editar Meus Dados</h1>

        <%-- Mensagem de sucesso ou erro (se houver) --%>
        <% if (request.getAttribute("mensagem") != null) { %>
            <p style="color: green;"><%= request.getAttribute("mensagem") %></p>
        <% } %>
        <% if (request.getAttribute("erro") != null) { %>
            <p style="color: red;"><%= request.getAttribute("erro") %></p>
        <% } %>

        <form action="atualizarCadastro" method="post">
            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome" value="<%= usuario.getNome() %>" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" value="<%= usuario.getEmail() %>" required><br><br>

            <label for="celular">Telefone:</label><br>
            <input type="text" id="celular" name="celular" value="<%= usuario.getCelular() %>"><br><br>

            <label for="cpf">CPF:</label><br>
            <input type="text" id="cpf" name="cpf" value="<%= usuario.getCpf() %>" readonly><br><br>
            <%-- O CPF geralmente não é editável, por isso 'readonly'. Se for editável, remova 'readonly'. --%>

            <label for="senha">Nova Senha (deixe em branco para não alterar):</label><br>
            <input type="password" id="senha" name="senha"><br><br>

            <label for="confirmarSenha">Confirmar Nova Senha:</label><br>
            <input type="password" id="confirmarSenha" name="confirmarSenha"><br><br>

            <input type="submit" value="Salvar Alterações">
        </form>

        <p><a href="meuCadastro">Cancelar e Voltar</a></p> <%-- Link para voltar à visualização --%>
    </div>

</body>
</html>