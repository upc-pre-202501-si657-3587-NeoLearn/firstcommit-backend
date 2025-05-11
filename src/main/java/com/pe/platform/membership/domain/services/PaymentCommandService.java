package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.entities.Payment;
import com.pe.platform.membership.domain.model.commands.CreatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
} 