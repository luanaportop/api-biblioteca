package com.example.demo.api.controller;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    // listar
    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> listarTodos() {
        return ResponseEntity.ok(categoriaService.listarTodos());
    }

    //criar
    @PostMapping
    public ResponseEntity<CategoriaEntity> salvar(@RequestBody CategoriaDTO dto) {
        //CategoriaEntity categoria = categoriaService.salvar(dto);
        return ResponseEntity.ok(categoriaService.salvar(dto));
    }

    //Listar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> atualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto){
        return ResponseEntity.ok(categoriaService.atualizar(id, dto));
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.ok("Categoria deletada com sucesso");
    }

}
