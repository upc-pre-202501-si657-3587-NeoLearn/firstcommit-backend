package com.pe.platform.membership.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.pe.platform.membership.domain.model.valueobjects.BenefitType;
import com.pe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Entity that represents a benefit that can be included in a membership plan
 */
@Entity
@Table(name = "benefits")
@Getter
@NoArgsConstructor
public class Benefit extends AuditableAbstractAggregateRoot<Benefit> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BenefitType type;

    public Benefit(String name, String description, BenefitType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }
} 