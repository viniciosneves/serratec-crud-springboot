package br.com.serratec.livraria.controller;

import br.com.serratec.livraria.dtos.LivroDTO;
import br.com.serratec.livraria.models.Livro;
import br.com.serratec.livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<LivroDTO> lista () {

        List<Livro> livros = repository.findAll();

        return LivroDTO.converter(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> detalhar (@PathVariable Long id) {

        Optional<Livro> optional = repository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Livro livro = optional.get();
        return  ResponseEntity.ok()
                .body(new LivroDTO(livro));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> cadastrar (@RequestBody LivroDTO input, UriComponentsBuilder builder) {

        Livro livro = input.toModel();
        repository.save(livro);

        URI uri = builder.path("/livros/{id}")
                .buildAndExpand(livro.getId())
                .toUri();

        return  ResponseEntity.created(uri)
                .body(new LivroDTO(livro));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LivroDTO> atualizar (@PathVariable Long id, @RequestBody LivroDTO input) {

        Optional<Livro> optional = repository.findById(id);

        Livro livro = optional.get();
        livro.setNome(input.getNome());
        livro.setCodigo(input.getCodigo());
        // atualizar o que quiser...

        return ResponseEntity.ok(new LivroDTO(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover (@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
