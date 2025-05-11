package com.pe.platform.membership.domain.model.commands;

public record CancelSubscriptionCommand(
    Long subscriptionId
) {
    public CancelSubscriptionCommand {
        if (subscriptionId == null || subscriptionId <= 0) {
            throw new IllegalArgumentException("Subscription ID must be valid");
        }
    }
} 