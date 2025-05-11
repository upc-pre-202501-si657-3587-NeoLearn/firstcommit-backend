package com.pe.platform.membership.application.internal.commandservices;

import com.pe.platform.membership.domain.model.aggregates.Subscription;
import com.pe.platform.membership.domain.model.commands.CreatePaymentCommand;
import com.pe.platform.membership.domain.model.entities.Payment;
import com.pe.platform.membership.domain.model.valueobjects.Money;
import com.pe.platform.membership.domain.services.PaymentCommandService;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.PaymentRepository;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;
    private final SubscriptionRepository subscriptionRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository, SubscriptionRepository subscriptionRepository) {
        this.paymentRepository = paymentRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        // Check if subscription exists
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(command.subscriptionId());
        if (optionalSubscription.isEmpty()) {
            throw new IllegalArgumentException("Subscription not found");
        }
        
        // Create payment
        Money amount = new Money(command.amount(), command.currencyCode());
        Payment payment = new Payment(
            command.subscriptionId(),
            amount,
            command.date(),
            command.status(),
            command.paymentMethod()
        );
        
        return Optional.of(paymentRepository.save(payment));
    }
} 