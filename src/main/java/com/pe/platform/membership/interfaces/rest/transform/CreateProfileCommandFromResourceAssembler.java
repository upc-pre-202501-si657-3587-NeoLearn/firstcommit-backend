package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.CreateProfileCommand;
import com.pe.platform.membership.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
            resource.userId(),
            resource.fullName(),
            resource.email(),
            resource.phone(),
            resource.bio()
        );
    }
} 