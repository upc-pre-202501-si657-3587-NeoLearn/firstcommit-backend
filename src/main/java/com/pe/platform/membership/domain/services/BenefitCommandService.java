package com.pe.platform.membership.domain.services;

import com.pe.platform.membership.domain.model.entities.Benefit;
import com.pe.platform.membership.domain.model.commands.CreateBenefitCommand;
import com.pe.platform.membership.domain.model.commands.UpdateBenefitCommand;

import java.util.Optional;

public interface BenefitCommandService {
    Optional<Benefit> handle(CreateBenefitCommand command);
    Optional<Benefit> handle(UpdateBenefitCommand command);
} 