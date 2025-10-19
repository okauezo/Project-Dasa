package br.com.fiap.dasa.model;


public class Imagem {
    private Long id; private String caminho; private String formato; private String resolucao; private Long exameId;
    public Imagem() {}
    public Imagem(Long id, String caminho, String formato, String resolucao, Long exameId) {
        this.id = id; this.caminho = caminho; this.formato = formato; this.resolucao = resolucao; this.exameId = exameId;
    }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getCaminho() { return caminho; } public void setCaminho(String caminho) { this.caminho = caminho; }
    public String getFormato() { return formato; } public void setFormato(String formato) { this.formato = formato; }
    public String getResolucao() { return resolucao; } public void setResolucao(String resolucao) { this.resolucao = resolucao; }
    public Long getExameId() { return exameId; } public void setExameId(Long exameId) { this.exameId = exameId; }
}