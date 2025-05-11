package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.entities.Payment;
import com.pe.platform.membership.domain.model.queries.GetPaymentByIdQuery;
import com.pe.platform.membership.domain.model.queries.GetPaymentsBySubscriptionIdQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuery query);
    List<Payment> handle(GetPaymentsBySubscriptionIdQuery query);
} 