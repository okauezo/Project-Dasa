package br.com.fiap.dasa.model;


import java.util.Objects;


public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String tipo; // ADMIN, MEDICO, TECNICO


    public Usuario() {}
    public Usuario(Long id, String nome, String email, String senha, String tipo) {
        this.id = id; this.nome = nome; this.email = email; this.senha = senha; this.tipo = tipo;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }


    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario that = (Usuario) o;
        return Objects.equals(email, that.email);
    }
    @Override public int hashCode() { return Objects.hash(email); }
    @Override public String toString() { return "Usuario{" + id + ", " + nome + ", " + email + ", tipo=" + tipo + '}'; }
}
