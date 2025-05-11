package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BenefitType;

public record UpdateBenefitResource(
    String name,
    String description,
    BenefitType type
) {
} 