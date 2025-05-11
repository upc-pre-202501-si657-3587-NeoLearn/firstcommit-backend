package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BillingPeriod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PlanResource(
    Long id,
    String name,
    String description,
    BigDecimal price,
    String currencyCode,
    BillingPeriod billingPeriod,
    boolean hasTrial,
    Integer trialDuration,
    List<BenefitResource> benefits,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
} 