package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.aggregates.Profile;
import com.pe.platform.membership.domain.model.queries.GetProfileByEmailQuery;
import com.pe.platform.membership.domain.model.queries.GetProfileByIdQuery;
import com.pe.platform.membership.domain.model.queries.GetProfileByUserIdQuery;

import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByUserIdQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
} 