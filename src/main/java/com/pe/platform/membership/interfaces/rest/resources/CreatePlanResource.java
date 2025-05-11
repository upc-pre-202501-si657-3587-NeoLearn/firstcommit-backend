package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BillingPeriod;

import java.math.BigDecimal;
import java.util.List;

public record CreatePlanResource(
    String name,
    String description,
    BigDecimal price,
    String currencyCode,
    BillingPeriod billingPeriod,
    boolean hasTrial,
    Integer trialDuration,
    List<Long> benefitIds
) {
} 