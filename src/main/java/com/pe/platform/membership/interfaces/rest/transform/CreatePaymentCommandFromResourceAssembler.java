package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreatePaymentCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreatePaymentResource;

import java.time.LocalDateTime;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(
            resource.getSubscriptionId(),
            resource.getAmount(),
            resource.getCurrency(),
            LocalDateTime.now(),
            resource.getPaymentStatus(),
            resource.getPaymentMethod()
        );
    }
} 