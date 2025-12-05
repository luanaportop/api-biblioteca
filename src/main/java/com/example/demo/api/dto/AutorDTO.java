package com.example.demo.api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorDTO {

    private Long id;
    private String nome;
    private String nacionalidade;

}
