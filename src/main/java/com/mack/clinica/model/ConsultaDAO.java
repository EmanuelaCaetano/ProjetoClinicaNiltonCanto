package com.mack.clinica.model;

import com.mack.clinica.util.DatabaseConnection;
import com.mack.clinica.model.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ConsultaDAO {

    private String pathBase;

    public ConsultaDAO(String pathBase) {
        this.pathBase = pathBase;
    }

    public List<Consulta> listarPorPaciente(int pacienteId) {
        List<Consulta> consultas = new ArrayList<>();
       String sql = """
        SELECT c.id, c.paciente_id, c.profissional_id, c.data_hora, c.status, c.observacoes, u.nome AS medico_nome
        FROM consultas c
        JOIN usuarios u ON c.profissional_id = u.id
        WHERE c.paciente_id = ?
        ORDER BY c.data_hora
    """;


        try (Connection conn = DatabaseConnection.getConnection(pathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setPacienteId(rs.getInt("paciente_id"));
                consulta.setProfissionalId(rs.getInt("profissional_id"));

                String dataHoraStr = rs.getString("data_hora");

                if (dataHoraStr != null && !dataHoraStr.isEmpty()) {
                    // Se estiver no formato "2025-04-19T01:40"
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr);
                    consulta.setDataHora(dataHora);
                }



                consulta.setStatus(rs.getString("status"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setMedico(rs.getString("medico_nome"));

                consultas.add(consulta);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar consultas: " + e.getMessage());
            e.printStackTrace();
        }

        return consultas;
    }
}

