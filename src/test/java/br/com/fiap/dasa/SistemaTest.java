package br.com.fiap.dasa;

import br.com.fiap.dasa.bo.AnaliseService;
import br.com.fiap.dasa.config.DatabaseInitializer;
import br.com.fiap.dasa.dao.impl.ExameDAOImpl;
import br.com.fiap.dasa.model.Exame;
import org.junit.jupiter.api.*;


import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;


public class SistemaTest {
    @BeforeAll static void setup() { DatabaseInitializer.init(); }


    @Test void deveCriarEEncontrarExame() {
        var dao = new ExameDAOImpl();
        Long id = dao.create(new Exame(null, "Citologia", LocalDate.now(), "NOVO", 1L));
        assertNotNull(id);
        assertTrue(dao.findById(id).isPresent());
    }


    @Test void analiseServiceDeveRetornarConfianca() {
        var ia = new AnaliseService().analisar(1L);
        assertNotNull(ia.getConfianca());
    }
}
