package com.example.springboot.infrastructure.loader;

import com.example.springboot.infrastructure.db.entities.CatEntity;
import com.example.springboot.infrastructure.db.repositories.CatJpaRepository;
import com.example.springboot.infrastructure.rest.dtos.CatResponseDTO;
import com.example.springboot.infrastructure.config.CatProperties;
import com.example.springboot.domain.models.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.List;

@Component
public class CatDataLoader implements CommandLineRunner {

    private final CatJpaRepository catRepository;
    private final CatProperties catProperties;
    private final ObjectMapper objectMapper;
    
    public CatDataLoader(CatJpaRepository catRepository,
                        CatProperties catProperties) {
        this.catRepository = catRepository;
        this.objectMapper = new ObjectMapper();
        this.catProperties = catProperties;
    }

    @Override
    public void run(String... args) throws Exception {

        URL url = new URL(catProperties.getDatasourceUrl());

        CatResponseDTO response =
                objectMapper.readValue(url, CatResponseDTO.class);

        List<CatEntity> cats = response.getCats().stream()
                .map(img -> new CatEntity(img.getId(), img.getUrl(), 0))
                .toList();

        catRepository.saveAll(cats);
    }
}