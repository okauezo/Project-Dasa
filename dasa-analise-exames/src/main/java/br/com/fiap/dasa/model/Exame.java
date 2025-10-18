package br.com.fiap.dasa.model;

import java.time.LocalDate;

public class Exame {
    private Long id;
    private String tipo;
    private LocalDate data;
    private String status; // NOVO, EM_ANALISE, CONCLUIDO
    private Long pacienteId;


    public Exame() {}
    public Exame(Long id, String tipo, LocalDate data, String status, Long pacienteId) {
        this.id = id; this.tipo = tipo; this.data = data; this.status = status; this.pacienteId = pacienteId;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
}