package com.pe.platform.membership.domain.model.queries;

public record GetSubscriptionByIdQuery(
    Long id
) {
    public GetSubscriptionByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Subscription ID must be valid");
        }
    }
} 