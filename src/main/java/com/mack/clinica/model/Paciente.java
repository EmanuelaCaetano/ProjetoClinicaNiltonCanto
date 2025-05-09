package com.mack.clinica.model;

public class Paciente extends Usuario {
    private String cpf;
    private String celular;

    public Paciente(int id, String nome, String email, String senha, String tipo, String cpf, String celular) {
        super(id, nome, email, senha, tipo);
        this.cpf = cpf;
        this.celular = celular;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    @Override
    public void exibirDados() {
        super.exibirDados(); // Chama o método da superclasse (Usuario)
        System.out.println(", CPF: " + cpf + ", Celular: " + celular);
    }
}
