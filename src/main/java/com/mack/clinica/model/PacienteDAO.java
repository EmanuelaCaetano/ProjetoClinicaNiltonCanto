package com.mack.clinica.model;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;
    import com.mack.clinica.util.DatabaseConnection; // Importe sua classe de conexão

    public class PacienteDAO {

        public void cadastrarPaciente(Paciente paciente) {
            String sql = "INSERT INTO usuarios (nome, email, cpf, celular, tipo, senha) VALUES (?, ?, ?, ?, 'paciente', ?)";
            try (Connection conn = DatabaseConnection.getConnection( "WEB-INF/db.db"); // Use sua classe de conexão
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, paciente.getNome());
                stmt.setString(2, paciente.getEmail());
                stmt.setString(3, paciente.getCpf());
                stmt.setString(4, paciente.getCelular());
                stmt.setString(5, paciente.getSenha()); // Hash this!
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Paciente> listarPacientes() {
            List<Paciente> pacientes = new ArrayList<>();
            String sql = "SELECT * FROM usuarios WHERE tipo = 'paciente'";
            try (Connection conn = DatabaseConnection.getConnection( "WEB-INF/db.db");
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setId(rs.getInt("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setCelular(rs.getString("celular"));
                    // Não inclua a senha na listagem por segurança
                    pacientes.add(paciente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return pacientes;
        }

        public Paciente buscarPacientePorId(int id) {
            Paciente paciente = null;
            String sql = "SELECT * FROM usuarios WHERE id = ? AND tipo = 'paciente'";
            try (Connection conn = DatabaseConnection.getConnection( "WEB-INF/db.db");
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setId(rs.getInt("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setCelular(rs.getString("celular"));
                    paciente.setSenha(rs.getString("senha")); // Para edição
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return paciente;
        }

        public void editarPaciente(Paciente paciente) {
            String sql = "UPDATE usuarios SET nome = ?, email = ?, cpf = ?, celular = ?, senha = ? WHERE id = ?";
            try (Connection conn = DatabaseConnection.getConnection( "WEB-INF/db.db");
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, paciente.getNome());
                stmt.setString(2, paciente.getEmail());
                stmt.setString(3, paciente.getCpf());
                stmt.setString(4, paciente.getCelular());
                stmt.setString(5, paciente.getSenha()); // Hash this!
                stmt.setInt(6, paciente.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void excluirPaciente(int id) {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
