package com.example.springboot.application.impl.usecases;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.models.enums.LikeType;
import com.example.springboot.domain.ports.input.cat.GetCatLeaderboardUseCase;
import com.example.springboot.domain.ports.input.cat.GetCatScoreUseCase;
import com.example.springboot.domain.ports.output.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCatLeaderboardService implements GetCatLeaderboardUseCase {

    private final CatRepository catRepository;

    public GetCatLeaderboardService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getLeaderboard() {
        return catRepository.findAllByOrderByScoreDesc();
    }
}