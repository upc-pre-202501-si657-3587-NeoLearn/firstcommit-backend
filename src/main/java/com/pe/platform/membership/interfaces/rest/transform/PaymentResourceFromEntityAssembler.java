package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.entities.Payment;
import com.pe.platform.membership.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {

    public static PaymentResource toResourceFromEntity(Payment entity) {
        return new PaymentResource(
            entity.getId(),
            entity.getSubscriptionId(),
            entity.getAmount().getAmount(),
            entity.getAmount().getCurrencyCode(),
            entity.getPaymentMethod(),
            entity.getStatus(),
            entity.getDate()
        );
    }
} 