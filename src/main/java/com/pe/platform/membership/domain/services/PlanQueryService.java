package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.aggregates.Plan;
import com.pe.platform.membership.domain.model.queries.GetAllPlansQuery;
import com.pe.platform.membership.domain.model.queries.GetPlanByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PlanQueryService {
    Optional<Plan> handle(GetPlanByIdQuery query);
    List<Plan> handle(GetAllPlansQuery query);
} 