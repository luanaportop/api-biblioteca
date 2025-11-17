    package com.example.demo.api.model;

    import jakarta.persistence.*;
    import lombok.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table(name = "TB_AUTOR")
    public class AutorEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "COD_AUTOR")
        private Long id;

        @Column(name = "AUTOR", nullable = false, length = 100)
        private String nome;

        @Column(name = "NACIONALIDADE", nullable = false, length = 100)
        private String nacionalidade;
    }
