package com.example.springboot.infrastructure.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatDTO {

    private String id;
    private String url;
    private Integer score;
}