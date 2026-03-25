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
class GetCatScoreServiceTest {

    private final CatRepository catRepository = mock(CatRepository.class);
    private final GetCatScoreService service = new GetCatScoreService(catRepository);

    @Test
    void shouldReturnScore_whenCatExists() {
        Cat cat = new Cat("1", "url", 10);
        when(catRepository.findById("1")).thenReturn(Optional.of(cat));

        Integer score = service.getScore("1");

        assertEquals(10, score);
        verify(catRepository).findById("1");
    }

    @Test
    void shouldThrowException_whenCatNotFound() {
        when(catRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(CatNotFoundException.class, () -> service.getScore("1"));
    }
}