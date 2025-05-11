package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BillingPeriod;

import java.math.BigDecimal;

public record UpdatePlanResource(
    String name,
    String description,
    BigDecimal price,
    String currencyCode,
    BillingPeriod billingPeriod,
    boolean hasTrial,
    Integer trialDuration
) {
} 