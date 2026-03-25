package com.example.springboot.application.impl.usecases;

import com.example.springboot.domain.exceptions.CatNotFoundException;
import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.ports.output.CatRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CatLikeScoreServiceTest {

    private final CatRepository catRepository = mock(CatRepository.class);
    private final CatLikeScoreService service = new CatLikeScoreService(catRepository);

    @Test
    void shouldAddLikeScore() {
        Cat cat = new Cat("1", "url", 0);
        when(catRepository.findById("1")).thenReturn(Optional.of(cat));

        service.like("1", LikeType.LIKE);

        assertEquals(1, cat.getScore());
        verify(catRepository).save(cat);
    }

    @Test
    void shouldAddSuperLikeScore() {
        Cat cat = new Cat("1", "url", 0);
        when(catRepository.findById("1")).thenReturn(Optional.of(cat));

        service.like("1", LikeType.SUPER_LIKE);

        assertEquals(5, cat.getScore());
        verify(catRepository).save(cat);
    }

    @Test
    void shouldThrowException_whenCatNotFound() {
        when(catRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(CatNotFoundException.class,
                () -> service.like("1", LikeType.LIKE));
    }
}