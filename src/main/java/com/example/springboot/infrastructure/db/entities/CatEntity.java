package com.example.springboot.infrastructure.db.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * JPA entity representing a cat.
 * A cat can get his score changed 
 */
@Entity
public class CatEntity {
    @Id
    private String id;
    private String imageUrl;
    private Integer score;

    public CatEntity() {} // JPA requires no-arg constructor

    public CatEntity(String id, String imageUrl, Integer score) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.score = score;
    }

    /**
     * @return the unique identifier of the cat
     */
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the image url of the cat
     */
    public String getImage() {
        return this.imageUrl;
    }

    public void setImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return the current score of the cat
     */
    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
