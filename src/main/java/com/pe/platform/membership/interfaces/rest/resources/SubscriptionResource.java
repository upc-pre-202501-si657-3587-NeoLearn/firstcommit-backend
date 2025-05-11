package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.SubscriptionStatus;

import java.time.LocalDateTime;

public record SubscriptionResource(
    Long id,
    Long userId,
    Long planId,
    PlanResource plan,
    SubscriptionStatus status,
    LocalDateTime startDate,
    LocalDateTime renewalDate,
    LocalDateTime endDate,
    LocalDateTime trialEndsAt,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
} 