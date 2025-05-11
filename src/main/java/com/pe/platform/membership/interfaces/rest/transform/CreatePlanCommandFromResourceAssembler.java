package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreatePlanCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreatePlanResource;

public class CreatePlanCommandFromResourceAssembler {
    public static CreatePlanCommand toCommandFromResource(CreatePlanResource resource) {
        boolean hasTrial = resource.getTrialDays() != null && resource.getTrialDays() > 0;
        
        return new CreatePlanCommand(
            resource.getName(),
            resource.getDescription(),
            resource.getPrice(),
            resource.getCurrency(),
            resource.getBillingPeriod(),
            hasTrial,
            resource.getTrialDays(),
            resource.getBenefitIds()
        );
    }
} 