package com.mack.clinica.model;

import com.mack.clinica.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProntuarioDAO {

    public boolean salvarProntuario(Prontuario prontuario, String realPathBase) {
        String sql = "INSERT INTO prontuarios (paciente_id, profissional_id, data, anotacoes_medicas, prescricoes) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prontuario.getPacienteId());
            stmt.setInt(2, prontuario.getProfissionalId());
            stmt.setString(3, prontuario.getData());
            stmt.setString(4, prontuario.getAnotacoesMedicas());
            stmt.setString(5, prontuario.getPrescricoes());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
