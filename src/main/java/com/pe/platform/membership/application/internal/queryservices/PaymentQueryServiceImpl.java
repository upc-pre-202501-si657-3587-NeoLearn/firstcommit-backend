package com.pe.platform.membership.application.internal.queryservices;

import com.pe.platform.membership.domain.model.entities.Payment;
import com.pe.platform.membership.domain.model.queries.GetPaymentByIdQuery;
import com.pe.platform.membership.domain.model.queries.GetPaymentsBySubscriptionIdQuery;
import com.pe.platform.membership.domain.services.PaymentQueryService;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.id());
    }

    @Override
    public List<Payment> handle(GetPaymentsBySubscriptionIdQuery query) {
        return paymentRepository.findBySubscriptionId(query.subscriptionId());
    }
} 