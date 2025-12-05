package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // listar todos
    public List<CategoriaEntity> listarTodos() {
        return categoriaRepository.findAll();
    }

    // criar
    public CategoriaEntity salvar(CategoriaDTO dto) {
        CategoriaEntity categoria;
        categoria = CategoriaEntity.builder()
                .categoria(dto.getCategoria())
                .build();
        return categoriaRepository.save(categoria);
    }

    //atualizar
    public CategoriaEntity atualizar(Long id, CategoriaDTO dto) {
        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setCategoria(dto.getCategoria());
        return categoriaRepository.save(categoria);
    }

    //deletar
    public void deletar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Autor não encontrado");
        }
        categoriaRepository.deleteById(id);
    }


}
