package com.mack.clinica.controller;

    import java.io.IOException;
    import java.util.List;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import com.mack.clinica.model.Paciente;
    import com.mack.clinica.model.PacienteDAO;

    @WebServlet("/PacienteController")
    public class PacienteController extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private final PacienteDAO pacienteDAO = new PacienteDAO();

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acao = request.getParameter("acao");
            if (acao == null) {
                acao = "listar";
            }

            switch (acao) {
                case "listar":
                    listarPacientes(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "excluir":
                    excluirPaciente(request, response);
                    break;
                default:
                    listarPacientes(request, response);
                    break;
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acao = request.getParameter("acao");
            if (acao == null) {
                acao = "listar";
            }

            switch (acao) {
                case "cadastrar":
                    cadastrarPaciente(request, response);
                    break;
                case "atualizar":
                    atualizarPaciente(request, response);
                    break;
                default:
                    listarPacientes(request, response);
                    break;
            }
        }

        private void listarPacientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Paciente> pacientes = pacienteDAO.listarPacientes();
            request.setAttribute("pacientes", pacientes);
            request.getRequestDispatcher("listar_pacientes.jsp").forward(request, response);
        }

        private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Paciente paciente = pacienteDAO.buscarPacientePorId(id);
            request.setAttribute("paciente", paciente);
            request.getRequestDispatcher("editar_paciente.jsp").forward(request, response);
        }

        private void cadastrarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String celular = request.getParameter("celular");
            String senha = request.getParameter("senha");

            Paciente paciente = new Paciente();
            paciente.setNome(nome);
            paciente.setEmail(email);
            paciente.setCpf(cpf);
            paciente.setCelular(celular);
            paciente.setSenha(senha);

            pacienteDAO.cadastrarPaciente(paciente);
            response.sendRedirect("PacienteController?acao=listar");
        }

        private void atualizarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String celular = request.getParameter("celular");
            String senha = request.getParameter("senha");

            Paciente paciente = new Paciente();
            paciente.setId(id);
            paciente.setNome(nome);
            paciente.setEmail(email);
            paciente.setCpf(cpf);
            paciente.setCelular(celular);
            paciente.setSenha(senha);

            pacienteDAO.editarPaciente(paciente);
            response.sendRedirect("PacienteController?acao=listar");
        }

        private void excluirPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            pacienteDAO.excluirPaciente(id);
            response.sendRedirect("PacienteController?acao=listar");
        }
    }