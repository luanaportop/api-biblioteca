package com.example.demo.api.controller;

import com.example.demo.api.dto.ListagemResumoDTO;
import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroService livroService;

    // listar
    @GetMapping
    public ResponseEntity<List<LivroEntity>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    // criar
    @PostMapping
    public ResponseEntity<LivroEntity> salvar(@RequestBody LivroDTO dto) {
        LivroEntity livro = livroService.criarLivro(dto);
        return ResponseEntity.ok(livro);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<LivroEntity> atualizar(@RequestBody LivroDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(livroService.atualizar(dto, id));
    }

    // Buscar por titulo
    @GetMapping("/titulo")
    public ResponseEntity<List<LivroEntity>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(livroService.buscarPorTitulo(titulo));
    }

    // Buscar por ISBN
    @GetMapping("/isbn")
    public ResponseEntity<LivroDTO> buscarPorIsbn(@RequestParam String isbn) {
        return ResponseEntity.ok(livroService.buscarPorIsbn(isbn));
    }

    //Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroEntity>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    // Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.ok("Livro deletado com sucesso.");
    }

    //Resumo query
    @GetMapping("/resumo")
    public ResponseEntity<List<ListagemResumoDTO>> buscarResumo(@RequestParam String titulo) {
        return ResponseEntity.ok(livroService.buscarTitAutorCategoria(titulo));
    }

}
