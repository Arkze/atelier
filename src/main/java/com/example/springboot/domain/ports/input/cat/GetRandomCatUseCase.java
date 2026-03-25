package com.example.springboot.domain.ports.input.cat;

import java.util.List;
import com.example.springboot.domain.models.Cat;

/**
 * Input port for retrieving the current score of a cat.
 */
public interface GetRandomCatUseCase {

    /**
     * Retrieves 2 random cats
     *
     * @return 2 random cats from the datas
     */
    List<Cat> getRandomCat();
}
