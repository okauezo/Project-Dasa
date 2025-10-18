package br.com.fiap.dasa.model;

public class Camera {
    private Long id; private String modelo; private String conexao; private String status;
    public Camera() {}
    public Camera(Long id, String modelo, String conexao, String status) {
        this.id = id; this.modelo = modelo; this.conexao = conexao; this.status = status;
    }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getModelo() { return modelo; } public void setModelo(String modelo) { this.modelo = modelo; }
    public String getConexao() { return conexao; } public void setConexao(String conexao) { this.conexao = conexao; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public void capturarImagem() { /* simulação */ }
}