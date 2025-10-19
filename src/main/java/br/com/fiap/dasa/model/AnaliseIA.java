package br.com.fiap.dasa.model;


public class AnaliseIA {
    private Long id; private Long exameId; private String resultado; private Double confianca;
    public AnaliseIA() {}
    public AnaliseIA(Long id, Long exameId, String resultado, Double confianca) {
        this.id = id; this.exameId = exameId; this.resultado = resultado; this.confianca = confianca;
    }


    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Long getExameId() { return exameId; } public void setExameId(Long exameId) { this.exameId = exameId; }
    public String getResultado() { return resultado; } public void setResultado(String resultado) { this.resultado = resultado; }
    public Double getConfianca() { return confianca; } public void setConfianca(Double confianca) { this.confianca = confianca; }
}