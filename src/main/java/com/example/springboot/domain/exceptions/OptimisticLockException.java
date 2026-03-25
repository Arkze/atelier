package com.example.springboot.domain.exceptions;

public class OptimisticLockException extends RuntimeException {
    public OptimisticLockException(String message) {
        super(message);
    }
}
