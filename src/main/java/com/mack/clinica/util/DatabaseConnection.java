package com.mack.clinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.ServletContext;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection(ServletContext context) { // Aceita ServletContext
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                if (context == null) {
                    throw new RuntimeException("ServletContext is null. Cannot determine database path.");
                }
                String dbURL = "jdbc:sqlite:WEB-INF/db.db";
                connection = DriverManager.getConnection(dbURL);
                System.out.println("Conexão com o banco de dados estabelecida.");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver do banco de dados não encontrado.", e);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
            }
        }
        return connection;
    }

    public static void closeConnection() { // Adicione um método para fechar a conexão
        try {
            if (connection != null) {
                connection.close();
                connection = null;
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Registre o erro, mas não interrompa a aplicação
        }
    }
}