package com.pe.platform.membership.domain.model.queries;

public record GetProfileByIdQuery(
    Long id
) {
    public GetProfileByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Profile ID must be valid");
        }
    }
} 