package com.example.springboot.application.impl.usecases;

import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.models.enums.LikeType;
import com.example.springboot.domain.ports.input.cat.GetCatScoreUseCase;
import com.example.springboot.domain.ports.output.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCatScoreService implements GetCatScoreUseCase {

    private final CatRepository catRepository;

    public GetCatScoreService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public Integer getScore(String catId) {

        Cat cat = catRepository.findById(catId)
                .orElseThrow(() -> new CatNotFoundException("Cat not found: " + catId));

        return cat.getScore();
    }
}