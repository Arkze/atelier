package com.example.springboot.infrastructure.db.repositories;

import com.example.springboot.infrastructure.db.entities.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository interface for {@link CatEntity}.
 * Provides basic CRUD operations for cats.
 */
public interface CatJpaRepository extends JpaRepository<CatEntity, String> {}
