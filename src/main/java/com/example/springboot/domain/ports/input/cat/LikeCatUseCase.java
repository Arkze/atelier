package com.example.springboot.domain.ports.input.cat;
import com.example.springboot.domain.models.enums.LikeType;

/**
 * Input port for crediting (adding funds to) a cat's score.
 */
public interface LikeCatUseCase {

    /**
     * Adds the specified amount to the cat's score.
     *
     * @param catId the ID of the cat
     * @param type the LikeType
     */
    void like(String catId, LikeType type);
}
