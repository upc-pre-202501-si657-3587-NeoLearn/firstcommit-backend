package com.pe.platform.membership.domain.model.queries;

import com.pe.platform.membership.domain.model.valueobjects.BenefitType;

public record GetBenefitsByTypeQuery(
    BenefitType type
) {
    public GetBenefitsByTypeQuery {
        if (type == null) {
            throw new IllegalArgumentException("Benefit type cannot be null");
        }
    }
} 