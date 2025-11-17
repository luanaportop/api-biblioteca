package com.example.demo.api.service;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    //Listar todos
    public List<AutorEntity> listarTodos() {
        return autorRepository.findAll();
    }

    // Criar
    public AutorEntity criar(AutorDTO dto) {
        AutorEntity autor = AutorEntity.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .build();

        return autorRepository.save(autor);
    }

    //Atualizar
    public AutorEntity atualizar(Long id, AutorDTO dto) {
        AutorEntity autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());

        return autorRepository.save(autor);
    }

    // Buscar por ID
    public AutorEntity buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    // Buscar por nome
    public List<AutorEntity> buscarPorNome(String nome) {
        return autorRepository.findByNomeContaining(nome);
    }

    // Deletar por ID
    public void deletar(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor não encontrado");
        }
        autorRepository.deleteById(id);
    }
}
