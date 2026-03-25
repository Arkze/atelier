package com.example.springboot.domain.models;

import java.util.*;

/**
 * Represents a cat with id image and score
 */

public class Cat {
    private final String id;
    private final String imageUrl;
    private Integer score;

    /**
     * Constructs a new cat with the given ID and image url.
     *
     * @param id   the unique identifier of the cat
     * @param imageUrl the url of the image of the cat
     */
    public Cat(String id, String imageUrl, Integer score) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.score = score;
    }

    /**
     * @return the unique identifier of the cat
     */
    public String getId() { return this.id; }

    /**
     * @return the name of the cat
     */
    public String getImage() { return this.imageUrl; }

    /**
     * Set a score for a cat
     *
     * @param score the score to add to the current score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return the current score of the cat
     */
    public Integer getScore() {
        return this.score;
    }

    public void addScore(Integer score) {
        this.score += score;
    }
}
