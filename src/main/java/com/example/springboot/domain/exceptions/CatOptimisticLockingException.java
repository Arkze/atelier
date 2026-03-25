package com.example.springboot.domain.exceptions;

public class CatOptimisticLockingException extends OptimisticLockException {
    public CatOptimisticLockingException(String message) {
        super(message);
    }
}
