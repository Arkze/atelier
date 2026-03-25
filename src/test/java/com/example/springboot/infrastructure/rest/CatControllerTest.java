package com.example.springboot.infrastructure.rest;

import com.example.springboot.domain.ports.input.cat.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import org.springframework.http.HttpStatus;

class CatControllerTest {

    private final GetCatScoreUseCase getCatScore = mock(GetCatScoreUseCase.class);
    private final LikeCatUseCase likeCat = mock(LikeCatUseCase.class);
    private final GetCatLeaderboardUseCase leaderboard = mock(GetCatLeaderboardUseCase.class);
    private final GetRandomCatUseCase random = mock(GetRandomCatUseCase.class);

    private final CatController controller =
            new CatController(getCatScore, likeCat, leaderboard, random);

    @Test
    void shouldReturnScore() {
        when(getCatScore.getScore("1")).thenReturn(10);

        ResponseEntity<Integer> response = controller.getScore("1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10, response.getBody());
    }
}