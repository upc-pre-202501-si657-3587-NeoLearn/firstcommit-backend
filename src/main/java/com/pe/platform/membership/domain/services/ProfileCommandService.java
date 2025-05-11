package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.aggregates.Profile;
import com.pe.platform.membership.domain.model.commands.CreateProfileCommand;
import com.pe.platform.membership.domain.model.commands.UpdateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(UpdateProfileCommand command);
} 