package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.entities.Benefit;
import com.pe.platform.membership.interfaces.rest.resources.BenefitResource;

public class BenefitResourceFromEntityAssembler {

    public static BenefitResource toResourceFromEntity(Benefit entity) {
        return new BenefitResource(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getType()
        );
    }
} 