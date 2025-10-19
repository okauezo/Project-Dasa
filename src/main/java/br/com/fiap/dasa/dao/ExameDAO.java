package br.com.fiap.dasa.dao;

import br.com.fiap.dasa.model.Exame;
import java.util.List; import java.util.Optional;


public interface ExameDAO {
    Long create(Exame e);
    Optional<Exame> findById(Long id);
    List<Exame> findAll();
    boolean update(Exame e);
    boolean delete(Long id);
}