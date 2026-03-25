package com.example.springboot.application.impl.usecases;

import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.ports.output.CatRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class GetCatLeaderboardServiceTest {

    private final CatRepository catRepository = mock(CatRepository.class);
    private final GetCatLeaderboardService service =
            new GetCatLeaderboardService(catRepository);

    @Test
    void shouldReturnLeaderboard() {
        List<Cat> cats = List.of(
                new Cat("1", "url1", 10),
                new Cat("2", "url2", 5)
        );

        when(catRepository.findAllByOrderByScoreDesc()).thenReturn(cats);

        List<Cat> result = service.getLeaderboard();

        assertEquals(2, result.size());
        verify(catRepository).findAllByOrderByScoreDesc();
    }
}