package com.pe.platform.membership.interfaces.rest.resources;

public record CreateTrialSubscriptionResource(
    Long userId,
    Long planId,
    Integer trialDays
) {
} 