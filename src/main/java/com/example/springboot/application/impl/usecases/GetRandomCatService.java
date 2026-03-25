package com.example.springboot.application.impl.usecases;

import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.ports.input.cat.GetRandomCatUseCase;
import com.example.springboot.domain.ports.output.CatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GetRandomCatService implements GetRandomCatUseCase {

    private final CatRepository catRepository;
    private final Random random = new Random();

    public GetRandomCatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getRandomCat() {
        List<Cat> allCats = new ArrayList<>(catRepository.findAllByOrderByScoreDesc()); 

        if (allCats.size() < 2) {
            throw new CatNotFoundException("Not enough cats to choose from.");
        }

        Cat first = allCats.remove(random.nextInt(allCats.size()));
        Cat second = allCats.remove(random.nextInt(allCats.size()));

        List<Cat> result = new ArrayList<>();
        result.add(first);
        result.add(second);

        return result;
    }
}