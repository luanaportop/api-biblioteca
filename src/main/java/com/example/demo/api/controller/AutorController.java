package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;

    //Buscar
    @GetMapping
    public ResponseEntity<List<AutorEntity>> listarTodos(){
        return ResponseEntity.ok(autorService.listarTodos());
    }

    //Criar
    @PostMapping
    public ResponseEntity<AutorEntity> criar(@RequestBody AutorDTO dto){
        return ResponseEntity.ok(autorService.criar(dto));
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<AutorEntity> atualizar(@PathVariable Long id, @RequestBody AutorDTO dto){
        return ResponseEntity.ok(autorService.atualizar(id, dto));
    }

    //Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    //Buscar por nome
    @GetMapping("/nome")
    public ResponseEntity<List<AutorEntity>> buscarPorNome(@RequestParam String nome){
        return ResponseEntity.ok(autorService.buscarPorNome(nome));
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.ok("Autor deletado com sucesso.");
    }
}
