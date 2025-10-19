package br.com.fiap.dasa.api;

import br.com.fiap.dasa.dao.impl.ExameDAOImpl;
import br.com.fiap.dasa.model.Exame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    private final ExameDAOImpl dao = new ExameDAOImpl();

    @GetMapping
    public List<Exame> listar() { return dao.findAll(); }

    @GetMapping("/{id}")
    public Exame buscar(@PathVariable Long id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException("Exame não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Exame> criar(@RequestBody Exame e) {
        Long id = dao.create(e);
        e.setId(id);
        return ResponseEntity.created(URI.create("/api/exames/" + id)).body(e);
    }

    @PutMapping("/{id}")
    public Exame atualizar(@PathVariable Long id, @RequestBody Exame e) {
        e.setId(id);
        if (!dao.update(e)) throw new NotFoundException("Exame não encontrado");
        return e;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        if (!dao.delete(id)) throw new NotFoundException("Exame não encontrado");
    }
}
