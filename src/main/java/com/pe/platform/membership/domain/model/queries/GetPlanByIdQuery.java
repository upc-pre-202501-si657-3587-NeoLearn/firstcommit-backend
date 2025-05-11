package com.pe.platform.membership.domain.model.queries;

public record GetPlanByIdQuery(
    Long id
) {
    public GetPlanByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Plan ID must be valid");
        }
    }
} 