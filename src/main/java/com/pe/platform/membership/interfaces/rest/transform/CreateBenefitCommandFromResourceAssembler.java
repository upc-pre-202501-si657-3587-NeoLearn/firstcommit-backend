package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreateBenefitCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreateBenefitResource;

public class CreateBenefitCommandFromResourceAssembler {
    public static CreateBenefitCommand toCommandFromResource(CreateBenefitResource resource) {
        return new CreateBenefitCommand(
            resource.getName(),
            resource.getDescription(),
            resource.getType()
        );
    }
} 