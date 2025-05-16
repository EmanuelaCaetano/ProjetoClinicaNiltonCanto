// package com.mack.clinica.model;

// /**
//  * Modelo que representa o usuário do sistema.
//  */
// public class Usuario {
//     private int id;
//     private String nome;
//     private String tipo; // paciente ou admin

//     // Getters e Setters
//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     public String getTipo() {
//         return tipo;
//     }

//     public void setTipo(String tipo) {
//         this.tipo = tipo;
//     }
// }

package com.mack.clinica.model;

/**
 * Modelo que representa o usuário do sistema.
 */
public class Usuario {
    private int id;
    private String nome;
    private String tipo; // paciente, admin ou medico
    private String email;
    private String cpf;
    private String celular;
    private String senha;

    // Construtor sem argumentos (adicionado)
    public Usuario() {
    }

    // Construtor que aceita os parâmetros esperados pela classe Paciente
    public Usuario(int id, String nome, String email, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
=======
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

>>>>>>> Emanuela
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
<<<<<<< HEAD

    // Método para exibir os dados do usuário
    public void exibirDados() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email + ", Tipo: " + tipo);
    }
}
=======
}
>>>>>>> Emanuela
