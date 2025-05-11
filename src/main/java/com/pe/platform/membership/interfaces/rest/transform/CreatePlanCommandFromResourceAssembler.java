package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreatePlanCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreatePlanResource;

public class CreatePlanCommandFromResourceAssembler {
    public static CreatePlanCommand toCommandFromResource(CreatePlanResource resource) {
        return new CreatePlanCommand(
            resource.name(),
            resource.description(),
            resource.price(),
            resource.currencyCode(),
            resource.billingPeriod(),
            resource.hasTrial(),
            resource.trialDuration(),
            resource.benefitIds()
        );
    }
} 