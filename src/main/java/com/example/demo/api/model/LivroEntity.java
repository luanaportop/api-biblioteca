package com.example.demo.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_LIVRO")
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_LIVRO")
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "ISBN", nullable = false, length = 20)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "Autor_id", nullable = false)
    private AutorEntity autor;

    @ManyToOne
    @JoinColumn(name = "Categoria_id")
    private CategoriaEntity categoria;

}
