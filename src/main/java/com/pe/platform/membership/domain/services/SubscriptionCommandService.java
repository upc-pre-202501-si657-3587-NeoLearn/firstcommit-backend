package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.aggregates.Subscription;
import com.pe.platform.membership.domain.model.commands.CancelSubscriptionCommand;
import com.pe.platform.membership.domain.model.commands.CreateSubscriptionCommand;
import com.pe.platform.membership.domain.model.commands.CreateTrialSubscriptionCommand;

import java.util.Optional;

public interface SubscriptionCommandService {
    Optional<Subscription> handle(CreateSubscriptionCommand command);
    Optional<Subscription> handle(CreateTrialSubscriptionCommand command);
    Optional<Subscription> handle(CancelSubscriptionCommand command);
} 