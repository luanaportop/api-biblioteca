package com.example.demo.api.repository;

import com.example.demo.api.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    List<LivroEntity> findByTituloContaining(String titulo);

    LivroEntity findByIsbn(String isbn);

    LivroEntity deleteByTitulo(String titulo);
}
