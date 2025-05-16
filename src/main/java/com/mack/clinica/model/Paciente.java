    package com.mack.clinica.model;

    public class Paciente {
        private int id;
        private String cpf;
        private String nome;
        private String email;
        private String celular;
        private String senha;

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
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getCelular() {
            return celular;
        }
        public void setCelular(String celular) {
            this.celular = celular;
        }
        protected String getSenha(){
            return senha;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }
        protected String getCpf() {
            return cpf;
        }
        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
    }
    
