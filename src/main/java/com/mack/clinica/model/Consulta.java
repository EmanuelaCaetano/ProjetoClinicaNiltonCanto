// package com.mack.clinica.model;

// public class Consulta {
//     private String data;
//     private String hora;
//     private String medico;
//     private String status;

//     // Getters e setters
//     public String getData() { return data; }
//     public void setData(String data) { this.data = data; }

//     public String getHora() { return hora; }
//     public void setHora(String hora) { this.hora = hora; }

//     public String getMedico() { return medico; }
//     public void setMedico(String medico) { this.medico = medico; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }

// package com.mack.clinica.model;

// public class Consulta {
//     private int id;
//     private int pacienteId;
//     private String data;
//     private String horario;
//     private String motivo;

//     // Getters e Setters
//     public int getId() {
//         return id;
//     }
//     public void setId(int id) {
//         this.id = id;
//     }

//     public int getPacienteId() {
//         return pacienteId;
//     }
//     public void setPacienteId(int pacienteId) {
//         this.pacienteId = pacienteId;
//     }

//     public String getData() {
//         return data;
//     }
//     public void setData(String data) {
//         this.data = data;
//     }

//     public String getHorario() {
//         return horario;
//     }
//     public void setHorario(String horario) {
//         this.horario = horario;
//     }

//     public String getMotivo() {
//         return motivo;
//     }
//     public void setMotivo(String motivo) {
//         this.motivo = motivo;
//     }
// }


package com.mack.clinica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {

    private int id;
    private int pacienteId;
    private int profissionalId;
    private LocalDateTime dataHora;
    private String status;
    private String observacoes;
    private String medico;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getProfissionalId() {
        return profissionalId;
    }
    public void setProfissionalId(int profissionalId) {
        this.profissionalId = profissionalId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getData() {
        return dataHora != null ? dataHora.toLocalDate().toString() : "";
    }

    public String getHorario() {
        return dataHora != null ? dataHora.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")) : "";
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getMedico() {
        return medico;
    }
    public void setMedico(String medico) {
        this.medico = medico;
    }
    private String pacienteNome;

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

}
