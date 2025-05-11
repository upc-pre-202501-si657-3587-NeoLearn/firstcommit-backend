package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.UpdateBenefitCommand;
import com.pe.platform.membership.interfaces.rest.resources.UpdateBenefitResource;

public class UpdateBenefitCommandFromResourceAssembler {
    public static UpdateBenefitCommand toCommandFromResource(Long benefitId, UpdateBenefitResource resource) {
        return new UpdateBenefitCommand(
            benefitId,
            resource.getName(),
            resource.getDescription(),
            resource.getType()
        );
    }
} 