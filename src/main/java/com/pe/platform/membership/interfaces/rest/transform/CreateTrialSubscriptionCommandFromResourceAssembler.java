package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreateTrialSubscriptionCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreateTrialSubscriptionResource;

public class CreateTrialSubscriptionCommandFromResourceAssembler {
    public static CreateTrialSubscriptionCommand toCommandFromResource(CreateTrialSubscriptionResource resource) {
        return new CreateTrialSubscriptionCommand(
            resource.userId(),
            resource.planId(),
            resource.trialDays()
        );
    }
} 