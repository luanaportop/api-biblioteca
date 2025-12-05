package com.example.demo.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    private String titulo;
    private String isbn;
    private Long autorId;
    private Long categoriaId;
}
