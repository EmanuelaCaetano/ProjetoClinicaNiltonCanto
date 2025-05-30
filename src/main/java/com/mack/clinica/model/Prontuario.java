package com.mack.clinica.model;

public class Prontuario {
    private int id;
    private int pacienteId;
    private int profissionalId;
    private String data;
    private String anotacoesMedicas;
    private String prescricoes;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPacienteId() { return pacienteId; }
    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; }

    public int getProfissionalId() { return profissionalId; }
    public void setProfissionalId(int profissionalId) { this.profissionalId = profissionalId; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getAnotacoesMedicas() { return anotacoesMedicas; }
    public void setAnotacoesMedicas(String anotacoesMedicas) { this.anotacoesMedicas = anotacoesMedicas; }

    public String getPrescricoes() { return prescricoes; }
    public void setPrescricoes(String prescricoes) { this.prescricoes = prescricoes; }
}
