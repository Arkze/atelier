package com.example.springboot.application.impl.usecases;

import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.ports.output.CatRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetRandomCatServiceTest {

    private final CatRepository catRepository = mock(CatRepository.class);
    private final GetRandomCatService service =
            new GetRandomCatService(catRepository);

    @Test
    void shouldReturnTwoDifferentCats() {
        List<Cat> cats = List.of(
                new Cat("1", "url1", 0),
                new Cat("2", "url2", 0),
                new Cat("3", "url3", 0)
        );

        when(catRepository.findAllByOrderByScoreDesc()).thenReturn(cats);

        List<Cat> result = service.getRandomCat();

        assertEquals(2, result.size());
        assertNotEquals(result.get(0).getId(), result.get(1).getId());
    }

    @Test
    void shouldThrowException_whenNotEnoughCats() {
        List<Cat> cats = List.of(
                new Cat("1", "url1", 0)
        );

        when(catRepository.findAllByOrderByScoreDesc()).thenReturn(cats);

        assertThrows(CatNotFoundException.class,
                () -> service.getRandomCat());
    }
}