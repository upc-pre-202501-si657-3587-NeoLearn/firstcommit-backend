package com.pe.platform.membership.domain.model.queries;

public record GetSubscriptionsByUserIdQuery(
    Long userId
) {
    public GetSubscriptionsByUserIdQuery {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User ID must be valid");
        }
    }
} 