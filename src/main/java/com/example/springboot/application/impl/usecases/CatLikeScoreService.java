package com.example.springboot.application.impl.usecases;

import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.models.enums.LikeType;
import com.example.springboot.domain.ports.input.cat.LikeCatUseCase;
import com.example.springboot.domain.ports.output.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class CatLikeScoreService implements LikeCatUseCase {

    private final CatRepository catRepository;

    public CatLikeScoreService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public void like(String catId, LikeType type) {

        Cat cat = catRepository.findById(catId)
                .orElseThrow(() -> new CatNotFoundException("Cat not found: " + catId));

        cat.addScore(type.getValue());
        catRepository.save(cat);
    }
}