package br.com.fiap.dasa.dao;

import br.com.fiap.dasa.model.Medico;
import java.util.List; import java.util.Optional;


public interface MedicoDAO {
    Long create(Medico m);
    Optional<Medico> findById(Long id);
    List<Medico> findAll();
    boolean update(Medico m);
    boolean delete(Long id);
}