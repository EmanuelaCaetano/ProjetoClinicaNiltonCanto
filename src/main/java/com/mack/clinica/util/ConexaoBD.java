package com.mack.clinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Substitua pela URL do seu banco
    private static final String USUARIO = "seu_usuario"; // Substitua pelo seu nome de usuário do banco
    private static final String SENHA = "sua_senha"; // Substitua pela sua senha do banco
    private static Connection conexao;

    private ConexaoBD() {
        // Construtor privado para evitar instanciação direta
    }

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                // Carrega o driver JDBC do MySQL (você pode precisar adicionar a dependência no seu projeto)
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("Conexão com o banco de dados estabelecida.");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            } finally {
                conexao = null;
            }
        }
    }
}
