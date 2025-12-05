package com.example.demo.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "categoriaSequence", sequenceName = "SEQ_CATEGORIA", allocationSize = 1)
    @Column(name = "COD_CATEGORIA")
    private long id;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

}
