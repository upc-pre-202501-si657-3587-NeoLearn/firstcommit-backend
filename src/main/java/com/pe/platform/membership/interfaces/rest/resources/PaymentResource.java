package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResource(
    Long id,
    Long subscriptionId,
    BigDecimal amount,
    String currencyCode,
    LocalDateTime date,
    PaymentStatus status,
    String paymentMethod,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
} 