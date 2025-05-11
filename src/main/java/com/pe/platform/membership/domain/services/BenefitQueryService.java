package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.entities.Benefit;
import com.pe.platform.membership.domain.model.queries.GetAllBenefitsQuery;
import com.pe.platform.membership.domain.model.queries.GetBenefitByIdQuery;
import com.pe.platform.membership.domain.model.queries.GetBenefitsByTypeQuery;

import java.util.List;
import java.util.Optional;

public interface BenefitQueryService {
    Optional<Benefit> handle(GetBenefitByIdQuery query);
    List<Benefit> handle(GetAllBenefitsQuery query);
    List<Benefit> handle(GetBenefitsByTypeQuery query);
} 