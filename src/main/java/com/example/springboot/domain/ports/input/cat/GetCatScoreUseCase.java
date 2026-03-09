package com.example.springboot.domain.ports.input.cat;

/**
 * Input port for retrieving the current score of a cat.
 */
public interface GetCatScoreUseCase {

    /**
     * Retrieves the score for the specified cat.
     *
     * @param catId the String id of the cat
     * @return the score as Integer
     */
    Integer getScore(String catId);
}
