package com.pe.platform.membership.domain.model.queries;

public record GetBenefitsByTypeQuery(
        String type
) {
    public GetBenefitsByTypeQuery {
        if (type == null) {
            throw new IllegalArgumentException("Benefit type cannot be null");
        }
    }
} 