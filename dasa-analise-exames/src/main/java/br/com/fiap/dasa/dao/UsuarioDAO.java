package br.com.fiap.dasa.dao;

import br.com.fiap.dasa.model.Usuario;
import java.util.List; import java.util.Optional;

public interface UsuarioDAO {
    Long create(Usuario u);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAll();
    boolean update(Usuario u);
    boolean delete(Long id);
}