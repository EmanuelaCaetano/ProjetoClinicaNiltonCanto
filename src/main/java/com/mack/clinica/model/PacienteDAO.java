package com.mack.clinica.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PacienteDAO {

    private Connection conexao;

    public PacienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Paciente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ? AND tipo = 'paciente'";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"), // **Cuidado: Não exiba a senha na tela!**
                        rs.getString("tipo"),
                        rs.getString("cpf"),
                        rs.getString("celular")
                    );
                }
            }
        }
        return null; // Retorna null se não encontrar o paciente
    }
}