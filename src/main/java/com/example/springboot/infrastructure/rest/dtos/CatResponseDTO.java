package com.example.springboot.infrastructure.rest.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CatResponseDTO {

    @JsonProperty("images")
    private List<CatDTO> cats;

    public List<CatDTO> getCats() {
        return cats;
    }

    public void setCats(List<CatDTO> cats) {
        this.cats = cats;
    }
}