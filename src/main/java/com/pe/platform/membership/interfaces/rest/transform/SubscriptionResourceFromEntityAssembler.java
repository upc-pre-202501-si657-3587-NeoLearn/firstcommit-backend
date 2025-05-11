package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.aggregates.Subscription;
import com.pe.platform.membership.interfaces.rest.resources.SubscriptionResource;


public class SubscriptionResourceFromEntityAssembler {

    public static SubscriptionResource toResourceFromEntity(Subscription entity) {
        return new SubscriptionResource(
            entity.getId(),
            entity.getUserId(),
            entity.getPlanId(),
            entity.getStatus(),
            entity.isActive(),
            entity.isInTrial(),
            entity.getStartDate(),
            entity.getRenewalDate(),
            entity.getEndDate(),
            entity.getTrialEndsAt()
        );
    }
} 