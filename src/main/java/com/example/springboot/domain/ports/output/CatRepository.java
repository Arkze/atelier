package com.example.springboot.domain.ports.output;

import com.example.springboot.domain.models.Cat;
import com.example.springboot.infrastructure.db.entities.CatEntity;

import java.util.Optional;
import java.util.List;

/**
 * Output port interface for accessing and persisting Cat data.
 */
public interface CatRepository {

    /**
     * Finds a cat by its unique identifier.
     *
     * @param id the id of the cat
     * @return an optional containing the cat if found
     */
    Optional<Cat> findById(String id);

    /**
     * Saves a cat to the persistence layer.
     *
     * @param cat the cat domain object to persist
     * @return the saved JPA entity
     */
    CatEntity save(Cat cat);

    List<Cat> saveAll(List<Cat> cats);

}
