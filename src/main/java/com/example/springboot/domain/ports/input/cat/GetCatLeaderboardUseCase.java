package com.example.springboot.domain.ports.input.cat;

import java.util.List;
import com.example.springboot.domain.models.Cat;

public interface GetCatLeaderboardUseCase {

    List<Cat> getLeaderboard();
}