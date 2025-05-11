package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.SubscriptionStatus;

public record CreateSubscriptionResource(
    Long userId,
    Long planId,
    SubscriptionStatus status
) {
} 