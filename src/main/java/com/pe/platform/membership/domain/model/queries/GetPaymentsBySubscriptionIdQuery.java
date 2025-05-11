package com.pe.platform.membership.domain.model.queries;

public record GetPaymentsBySubscriptionIdQuery(
    Long subscriptionId
) {
    public GetPaymentsBySubscriptionIdQuery {
        if (subscriptionId == null || subscriptionId <= 0) {
            throw new IllegalArgumentException("Subscription ID must be valid");
        }
    }
} 