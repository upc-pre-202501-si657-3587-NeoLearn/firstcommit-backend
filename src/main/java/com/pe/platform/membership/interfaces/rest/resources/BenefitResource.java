package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BenefitType;

import java.time.LocalDateTime;

public record BenefitResource(
    Long id,
    String name,
    String description,
    BenefitType type,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
} 