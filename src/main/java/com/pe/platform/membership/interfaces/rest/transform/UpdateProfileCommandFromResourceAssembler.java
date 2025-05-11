package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.commands.UpdateProfileCommand;
import com.pe.platform.membership.interfaces.rest.resources.UpdateProfileResource;

public class UpdateProfileCommandFromResourceAssembler {
    public static UpdateProfileCommand toCommandFromResource(Long profileId, UpdateProfileResource resource) {
        return new UpdateProfileCommand(
            profileId,
            resource.getFullName(),
            null, 
            resource.getPhone(),
            resource.getBio()
        );
    }
} 