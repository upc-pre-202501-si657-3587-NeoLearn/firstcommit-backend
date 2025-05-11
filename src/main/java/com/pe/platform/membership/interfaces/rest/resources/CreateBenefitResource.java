package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BenefitType;

public record CreateBenefitResource(
    String name,
    String description,
    BenefitType type
) {
} 