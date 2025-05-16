<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.mack.clinica.model.Paciente" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Listar Pacientes</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <h1>Listar Pacientes</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Celular</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% List<Paciente> pacientes = (List<Paciente>) request.getAttribute("pacientes");
                   if (pacientes != null) {
                       for (Paciente paciente : pacientes) { %>
                           <tr>
                               <td><%= paciente.getId() %></td>
                               <td><%= paciente.getNome() %></td>
                               <td><%= paciente.getEmail() %></td>
                               <td><%= paciente.getCpf() %></td>
                               <td><%= paciente.getCelular() %></td>
                               <td>
                                   <a href="PacienteController?acao=editar&id=<%= paciente.getId() %>">Editar</a> |
                                   <a href="PacienteController?acao=excluir&id=<%= paciente.getId() %>" onclick="return confirm('Tem certeza?')">Excluir</a>
                               </td>
                           </tr>
                <%     }
                   } %>
            </tbody>
        </table>
        <a href="admin_dashboard.jsp">Voltar ao Dashboard</a>
    </body>
    </html>