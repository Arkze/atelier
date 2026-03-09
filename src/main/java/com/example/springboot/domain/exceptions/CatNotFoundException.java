package com.example.springboot.domain.exceptions;

public class CatNotFoundException extends NotFoundException {
    public CatNotFoundException(String message) {
        super(message);
    }
}
