package com.pe.platform.membership.domain.model.queries;

public record GetProfileByEmailQuery(
    String email
) {
    public GetProfileByEmailQuery {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }
} 