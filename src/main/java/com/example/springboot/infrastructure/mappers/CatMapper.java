package com.example.springboot.infrastructure.mappers;

import com.example.springboot.domain.models.Cat;
import com.example.springboot.infrastructure.db.entities.CatEntity;

/**
 * Mapper class for converting between {@link Cat} domain models and {@link CatEntity} persistence entities.
 */
public class CatMapper {

    /**
     * Converts a {@link CatEntity} to a {@link Cat} domain object.
     *
     * @param entity the persistence entity to convert
     * @return the mapped domain Cat object
     */
    public static Cat toDomain(CatEntity entity) {
        return new Cat(entity.getId(), entity.getImage(), entity.getScore());
    }

    /**
     * Converts a {@link Cat} domain object to a {@link CatEntity} for persistence.
     *
     * @param cat the domain object to convert
     * @return the mapped persistence CatEntity object
     */
    public static CatEntity toEntity(Cat cat) {
        CatEntity entity = new CatEntity();
        entity.setId(cat.getId());
        entity.setImage(cat.getImage());
        entity.setScore(cat.getScore());
        return entity;
    }
}
