package com.pe.platform.membership.interfaces.rest.transform;

import com.pe.platform.membership.domain.model.aggregates.Profile;
import com.pe.platform.membership.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {

    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(
            entity.getId(),
            entity.getUserId(),
            entity.getFullName(),
            entity.getEmail(),
            entity.getPhone(),
            entity.getBio()
        );
    }
} 