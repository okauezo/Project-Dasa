package br.com.fiap.dasa.api;

import br.com.fiap.dasa.dao.impl.MedicoDAOImpl;
import br.com.fiap.dasa.model.Medico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    private final MedicoDAOImpl dao = new MedicoDAOImpl();

    @GetMapping
    public List<Medico> listar() { return dao.findAll(); }

    @GetMapping("/{id}")
    public Medico buscar(@PathVariable Long id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException("Médico não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Medico> criar(@RequestBody Medico m) {
        Long id = dao.create(m);
        m.setId(id);
        return ResponseEntity.created(URI.create("/api/medicos/" + id)).body(m);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody Medico m) {
        m.setId(id);
        if (!dao.update(m)) throw new NotFoundException("Médico não encontrado");
        return m;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        if (!dao.delete(id)) throw new NotFoundException("Médico não encontrado");
    }
}
