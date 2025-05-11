package com.pe.platform.membership.interfaces.rest.resources;

import com.pe.platform.membership.domain.model.valueobjects.BenefitType;

public class CreateBenefitResource {
    private String name;
    private String description;
    private BenefitType type;

    public CreateBenefitResource() {
    }

    public CreateBenefitResource(String name, String description, BenefitType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BenefitType getType() {
        return type;
    }

    public void setType(BenefitType type) {
        this.type = type;
    }
} 