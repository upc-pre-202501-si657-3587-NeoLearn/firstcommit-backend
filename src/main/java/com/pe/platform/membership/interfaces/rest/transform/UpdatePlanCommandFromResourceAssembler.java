package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.UpdatePlanCommand;
import com.pe.platform.membership.interfaces.rest.resources.UpdatePlanResource;

public class UpdatePlanCommandFromResourceAssembler {
    public static UpdatePlanCommand toCommandFromResource(Long planId, UpdatePlanResource resource) {
        return new UpdatePlanCommand(
            planId,
            resource.name(),
            resource.description(),
            resource.price(),
            resource.currencyCode(),
            resource.billingPeriod(),
            resource.hasTrial(),
            resource.trialDuration()
        );
    }
} 