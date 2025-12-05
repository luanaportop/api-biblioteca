package com.example.demo.api.repository;

import com.example.demo.api.dto.ListagemResumoDTO;
import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    List<LivroEntity> findByTituloContaining(String titulo);

    LivroDTO findByIsbn(String isbn);

    @Query("SELECT new com.example.demo.api.dto.ListagemResumoDTO(l.titulo, l.autor.nome, l.categoria.categoria) "
            + "FROM LivroEntity l WHERE l.titulo LIKE %:titulo%")
    List<ListagemResumoDTO> buscarTitAutorCategoria(@Param("titulo") String titulo);
}