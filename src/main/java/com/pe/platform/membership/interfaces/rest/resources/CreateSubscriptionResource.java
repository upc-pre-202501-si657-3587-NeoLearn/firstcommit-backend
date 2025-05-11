package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.SubscriptionStatus;

public class CreateSubscriptionResource {
    private Long userId;
    private Long planId;
    private SubscriptionStatus status;

    public CreateSubscriptionResource() {
    }

    public CreateSubscriptionResource(Long userId, Long planId, SubscriptionStatus status) {
        this.userId = userId;
        this.planId = planId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }
} 