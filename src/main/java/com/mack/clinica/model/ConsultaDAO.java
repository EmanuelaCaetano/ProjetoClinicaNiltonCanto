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


        try (Connection conn = DatabaseConnection.getConnection("WEB-INF/db.db");
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

    public List<Consulta> listarTodasComFiltros(String medicoNome, String pacienteNome, String dataFiltro) {
    List<Consulta> consultas = new ArrayList<>();

    StringBuilder sql = new StringBuilder("""
        SELECT c.id, c.paciente_id, c.profissional_id, c.data_hora, c.status, 
               c.observacoes, u.nome AS medico_nome, p.nome AS paciente_nome
        FROM consultas c
        JOIN usuarios u ON c.profissional_id = u.id
        JOIN usuarios p ON c.paciente_id = p.id
        WHERE 1=1
    """);

    if (medicoNome != null && !medicoNome.isEmpty()) {
        sql.append(" AND u.nome LIKE ? ");
    }

    if (pacienteNome != null && !pacienteNome.isEmpty()) {
        sql.append(" AND p.nome LIKE ? ");
    }

    if (dataFiltro != null && !dataFiltro.isEmpty()) {
        sql.append(" AND DATE(c.data_hora) = ? ");
    }

    sql.append(" ORDER BY c.data_hora");

    try (Connection conn = DatabaseConnection.getConnection(pathBase);
         PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

        int paramIndex = 1;

        if (medicoNome != null && !medicoNome.isEmpty()) {
            stmt.setString(paramIndex++, "%" + medicoNome + "%");
        }

        if (pacienteNome != null && !pacienteNome.isEmpty()) {
            stmt.setString(paramIndex++, "%" + pacienteNome + "%");
        }

        if (dataFiltro != null && !dataFiltro.isEmpty()) {
            stmt.setString(paramIndex++, dataFiltro);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta consulta = new Consulta();
            consulta.setId(rs.getInt("id"));
            consulta.setPacienteId(rs.getInt("paciente_id"));
            consulta.setProfissionalId(rs.getInt("profissional_id"));

            String dataHoraStr = rs.getString("data_hora");
            if (dataHoraStr != null && !dataHoraStr.isEmpty()) {
                consulta.setDataHora(LocalDateTime.parse(dataHoraStr));
            }

            consulta.setStatus(rs.getString("status"));
            consulta.setObservacoes(rs.getString("observacoes"));
            consulta.setMedico(rs.getString("medico_nome"));

            // Aqui você pode salvar pacienteNome, se quiser exibir
            consulta.setPacienteNome(rs.getString("paciente_nome"));

            consultas.add(consulta);
        }

    } catch (SQLException e) {
        System.err.println("Erro ao listar consultas (admin): " + e.getMessage());
        e.printStackTrace();
    }

    return consultas;
}

public List<String> listarNomesMedicos() {
    List<String> medicos = new ArrayList<>();
    String sql = "SELECT DISTINCT u.nome FROM usuarios u JOIN consultas c ON u.id = c.profissional_id";

    try (Connection conn = DatabaseConnection.getConnection(pathBase);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            medicos.add(rs.getString("nome"));
        }

    } catch (SQLException e) {
        System.err.println("Erro ao listar médicos: " + e.getMessage());
        e.printStackTrace();
    }

    return medicos;
}


}

