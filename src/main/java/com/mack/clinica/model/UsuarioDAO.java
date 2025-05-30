// package com.mack.clinica.model;

// import com.mack.clinica.util.DatabaseConnection;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import com.mack.clinica.model.Usuario;

// public class UsuarioDAO {

//     /**
//      * Consulta o usuário pelo email e senha no banco.
//      * @param email Email do usuário.
//      * @param senha Senha do usuário.
//      * @param realPathBase Caminho real da aplicação para localizar o banco.
//      * @return Objeto Usuario encontrado ou null se não encontrado.
//      */
//     public static Usuario buscarUsuario(String email, String senha, String realPathBase) {
//         try (Connection conn = DatabaseConnection.getConnection(realPathBase)) {
//             String sql = "SELECT id, nome, tipo FROM usuarios WHERE email = ? AND senha = ?";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setString(1, email);
//             stmt.setString(2, senha);

//             ResultSet rs = stmt.executeQuery();

//             if (rs.next()) {
//                 // Se encontrou o usuário, cria um objeto Usuario
//                 Usuario usuario = new Usuario();
//                 usuario.setId(rs.getInt("id"));
//                 usuario.setNome(rs.getString("nome"));
//                 usuario.setTipo(rs.getString("tipo"));
//                 return usuario;
//             }

//         } catch (SQLException e) {
//             e.printStackTrace();
//             throw new RuntimeException("Erro ao buscar usuário no banco de dados.", e);
//         }
//         return null;
//     }
// }

package com.mack.clinica.model;

import com.mack.clinica.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    /**
     * Consulta o usuário pelo email e senha no banco.
     */
    public static Usuario buscarUsuario(String email, String senha, String realPathBase) {
        try (Connection conn = DatabaseConnection.getConnection(realPathBase)) {
            //atualizada para mostrar todos os dados em /MeuCadastro
            String sql = "SELECT id, nome, email, cpf, celular, tipo, senha FROM usuarios WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //setters atualizados para incluir todos os dados do usuário
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setTipo(rs.getString("tipo"));                    usuario.setSenha(rs.getString("senha")); // Só se necessário
                return usuario;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar usuário no banco de dados.", e);
        }
        return null;
    }

    /**
     * Cadastra um novo médico no banco.
     */
    public void cadastrarMedico(Usuario medico, String realPathBase) {
        String sql = "INSERT INTO usuarios (nome, email, cpf, celular, tipo, senha, created_at) " +
                     "VALUES (?, ?, ?, ?, ?, ?, datetime('now'))";

        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEmail());
            stmt.setString(3, medico.getCpf());
            stmt.setString(4, medico.getCelular());
            stmt.setString(5, "medico"); // tipo fixo para médico
            stmt.setString(6, medico.getSenha());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar médico.", e);
        }
    }
    public static boolean atualizarUsuario(Usuario usuario, String realPathBase) {
    String sql = "UPDATE usuarios SET nome = ?, email = ?, celular = ?, senha = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCelular());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao atualizar usuário.", e);
            }
    }

//metodo para cadastrar paciente > sera usado em CadastrarPacienteServlet.java
    public void cadastrarPaciente(Usuario paciente, String realPathBase) {
        String sql = "INSERT INTO usuarios (nome, email, cpf, celular, tipo, senha, created_at) " +
                    "VALUES (?, ?, ?, ?, 'paciente', ?, datetime('now'))";

        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getEmail());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getCelular());
            stmt.setString(5, paciente.getSenha());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar paciente.", e);
        }
    }
    //metodo que sera usado para os prontuarios
    public static List<Usuario> listarPacientes(String realPathBase) {
    List<Usuario> pacientes = new ArrayList<>();
    String sql = "SELECT id, nome FROM usuarios WHERE tipo = 'paciente'";

    try (Connection conn = DatabaseConnection.getConnection(realPathBase);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            pacientes.add(u);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pacientes;
}



}
