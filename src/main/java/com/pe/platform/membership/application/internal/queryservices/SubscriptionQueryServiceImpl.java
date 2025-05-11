package com.pe.platform.membership.application.internal.queryservices;

import com.pe.platform.membership.domain.model.aggregates.Subscription;
import com.pe.platform.membership.domain.model.queries.GetActiveSubscriptionByUserIdQuery;
import com.pe.platform.membership.domain.model.queries.GetSubscriptionByIdQuery;
import com.pe.platform.membership.domain.model.queries.GetSubscriptionsByUserIdQuery;
import com.pe.platform.membership.domain.services.SubscriptionQueryService;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByIdQuery query) {
        return subscriptionRepository.findById(query.id());
    }

    @Override
    public List<Subscription> handle(GetSubscriptionsByUserIdQuery query) {
        return subscriptionRepository.findByUserId(query.userId());
    }

    @Override
    public Optional<Subscription> handle(GetActiveSubscriptionByUserIdQuery query) {
        return subscriptionRepository.findActiveByUserId(query.userId());
    }
} 