package com.example.demo.api.service;

import com.example.demo.api.dto.ListagemResumoDTO;
import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.AutorRepository;
import com.example.demo.api.repository.CategoriaRepository;
import com.example.demo.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar livros
    public List<LivroEntity> listarTodos(){
        return livroRepository.findAll();
    }

    // Buscar por título
    public List<LivroEntity> buscarPorTitulo(String titulo){
        return livroRepository.findByTituloContaining(titulo);
    }

    //Buscar por isbn

    public LivroDTO buscarPorIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn);
    }

    // Criar Livro

    public LivroEntity criarLivro(LivroDTO dto) {
        // Buscar o autor pelo ID (validar se existe)
        AutorEntity autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        // Buscar a categoria pelo ID (validar se existe)
        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        // Criar a entidade Livro e preencher os dados
        LivroEntity livro = LivroEntity.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .autor(autor)
                .categoria(categoria)
                .build();

        return livroRepository.save(livro);
    }

    //atualizar
    public LivroEntity atualizar(LivroDTO dto, Long id) {
        LivroEntity livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());

        AutorEntity autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        livro.setAutor(autor);

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        livro.setCategoria(categoria);

        return livroRepository.save(livro);
    }


    // Buscar por id
    public Optional<LivroEntity> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    // Deletar livro pelo ID
    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
        livroRepository.deleteById(id);
    }

    //Teste de query
    public List<ListagemResumoDTO> buscarTitAutorCategoria(String titulo) {
        return livroRepository.buscarTitAutorCategoria(titulo);
    }


}

