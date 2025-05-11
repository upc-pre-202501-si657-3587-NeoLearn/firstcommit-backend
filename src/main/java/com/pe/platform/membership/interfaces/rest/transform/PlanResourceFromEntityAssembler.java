package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.aggregates.Plan;
import com.pe.platform.membership.interfaces.rest.resources.BenefitResource;
import com.pe.platform.membership.interfaces.rest.resources.PlanResource;

import java.util.stream.Collectors;

public class PlanResourceFromEntityAssembler {
    public static PlanResource toResourceFromEntity(Plan entity) {
        return new PlanResource(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getPrice().getAmount(),
            entity.getPrice().getCurrencyCode(),
            entity.getBillingPeriod(),
            entity.isHasTrial(),
            entity.getTrialDuration(),
            entity.getBenefits().stream()
                .map(benefit -> new BenefitResource(
                    benefit.getId(),
                    benefit.getName(),
                    benefit.getDescription(),
                    benefit.getType(),
                    benefit.getCreatedAt(),
                    benefit.getUpdatedAt()
                ))
                .collect(Collectors.toList()),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
} 