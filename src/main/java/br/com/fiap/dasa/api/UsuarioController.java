package br.com.fiap.dasa.api;

import br.com.fiap.dasa.dao.impl.UsuarioDAOImpl;
import br.com.fiap.dasa.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioDAOImpl dao = new UsuarioDAOImpl();

    @GetMapping
    public List<Usuario> listar() { return dao.findAll(); }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario u) {
        Long id = dao.create(u);
        u.setId(id);
        return ResponseEntity.created(URI.create("/api/usuarios/" + id)).body(u);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        if (!dao.update(u)) throw new NotFoundException("Usuário não encontrado");
        return u;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        if (!dao.delete(id)) throw new NotFoundException("Usuário não encontrado");
    }
}
