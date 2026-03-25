package com.example.springboot.infrastructure.adapters;

import com.example.springboot.domain.models.Cat;
import com.example.springboot.domain.ports.output.CatRepository;
import com.example.springboot.infrastructure.db.entities.CatEntity;
import com.example.springboot.infrastructure.db.repositories.CatJpaRepository;
import com.example.springboot.infrastructure.mappers.CatMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * Adapter for cat repository, responsible for saving and retrieving companies.
 */
@Repository
public class CatRepositoryAdapter implements CatRepository {

    private final CatJpaRepository catJpaRepository;

    public CatRepositoryAdapter(CatJpaRepository catJpaRepository) {
        this.catJpaRepository = catJpaRepository;
    }

    /**
     * Finds a cat by its ID.
     *
     * @param id the id of the cat
     * @return optional of the domain cat if found
     */
    @Override
    public Optional<Cat> findById(String id) {
        return catJpaRepository.findById(id).map(CatMapper::toDomain);
    }

    /**
     * Saves a cat to the database.
     *
     * @param cat the domain cat
     * @return the saved JPA entity
     */
    @Override
    public CatEntity save(Cat cat) {
        return catJpaRepository.save(CatMapper.toEntity(cat));
    }

    @Override
    public List<Cat> saveAll(List<Cat> cats) {

        List<CatEntity> entities = cats.stream()
                .map(CatMapper::toEntity)
                .toList();

        return catJpaRepository.saveAll(entities)
                .stream()
                .map(CatMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cat> findAllByOrderByScoreDesc() {
        return catJpaRepository.findAllByOrderByScoreDesc()
                .stream()
                .map(CatMapper::toDomain)
                .toList();
    }
}
