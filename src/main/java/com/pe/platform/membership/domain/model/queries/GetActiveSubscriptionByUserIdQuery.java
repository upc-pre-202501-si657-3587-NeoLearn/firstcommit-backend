package com.pe.platform.membership.domain.model.queries;

public record GetActiveSubscriptionByUserIdQuery(
    Long userId
) {
    public GetActiveSubscriptionByUserIdQuery {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User ID must be valid");
        }
    }
} 