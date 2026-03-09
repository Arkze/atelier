package com.example.springboot.domain.models.enums;

/**
 * Enumeration of available like types.
 */
public enum LikeType {

    /** Standard like worth 1 point */
    LIKE(1),

    /** Super like worth 5 points */
    SUPER_LIKE(5);

    private final int value;

    LikeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}