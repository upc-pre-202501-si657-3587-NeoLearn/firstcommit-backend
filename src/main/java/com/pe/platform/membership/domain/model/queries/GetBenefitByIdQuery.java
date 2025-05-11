package com.pe.platform.membership.domain.model.queries;

public record GetBenefitByIdQuery(
    Long id
) {
    public GetBenefitByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Benefit ID must be valid");
        }
    }
} 