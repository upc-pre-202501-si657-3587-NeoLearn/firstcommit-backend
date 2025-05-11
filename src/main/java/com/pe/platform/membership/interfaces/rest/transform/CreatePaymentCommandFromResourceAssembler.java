package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreatePaymentCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(
            resource.subscriptionId(),
            resource.amount(),
            resource.currencyCode(),
            resource.date(),
            resource.status(),
            resource.paymentMethod()
        );
    }
} 