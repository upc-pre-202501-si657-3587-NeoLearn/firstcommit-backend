package com.pe.platform.membership.application.internal.commandservices;

import com.pe.platform.iam.infrastructure.authorization.sfs.model.UserDetailsImpl;
import com.pe.platform.membership.domain.model.aggregates.Plan;
import com.pe.platform.membership.domain.model.commands.AddBenefitToPlanCommand;
import com.pe.platform.membership.domain.model.commands.CreatePlanCommand;
import com.pe.platform.membership.domain.model.commands.RemoveBenefitFromPlanCommand;
import com.pe.platform.membership.domain.model.commands.UpdatePlanCommand;
import com.pe.platform.membership.domain.model.entities.Benefit;
import com.pe.platform.membership.domain.model.valueobjects.Money;
import com.pe.platform.membership.domain.services.PlanCommandService;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.BenefitRepository;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.PlanRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PlanCommandServiceImpl implements PlanCommandService {

    private final PlanRepository planRepository;
    private final BenefitRepository benefitRepository;

    public PlanCommandServiceImpl(PlanRepository planRepository, BenefitRepository benefitRepository) {
        this.planRepository = planRepository;
        this.benefitRepository = benefitRepository;
    }

    @Override
    public Optional<Plan> handle(CreatePlanCommand command) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        boolean hasRequiredRole = authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (hasRequiredRole) {
            Optional<Plan> existingPlan = planRepository.findByName(command.name());
            if (existingPlan.isPresent()) {
                throw new IllegalStateException("A plan with that name already exists");
            }
            
            Money price = new Money(command.price(), command.currencyCode());
            Plan plan = new Plan(command.name(), command.description(), price, command.billingPeriod());
            
            if (command.hasTrial()) {
                plan.withTrial(command.trialDuration());
            }
            
            // Add benefits if provided
            if (command.benefitIds() != null && !command.benefitIds().isEmpty()) {
                for (Long benefitId : command.benefitIds()) {
                    benefitRepository.findById(benefitId).ifPresent(plan::addBenefit);
                }
            }
            
            return Optional.of(planRepository.save(plan));
        } else {
            throw new SecurityException("Only admins can create a plan");
        }
    }

    @Override
    public Optional<Plan> handle(UpdatePlanCommand command) {
        return planRepository.findById(command.id())
                .map(plan -> {
                    // Update only the fields that are provided
                    if (command.name() != null) {
                        plan.setName(command.name());
                    }
                    
                    if (command.description() != null) {
                        plan.setDescription(command.description());
                    }
                    
                    if (command.price() != null && command.currencyCode() != null) {
                        plan.setPrice(new Money(command.price(), command.currencyCode()));
                    }
                    
                    if (command.billingPeriod() != null) {
                        plan.setBillingPeriod(command.billingPeriod());
                    }
                    
                    // Update trial settings
                    if (command.hasTrial() && command.trialDuration() != null) {
                        plan.withTrial(command.trialDuration());
                    }
                    
                    return planRepository.save(plan);
                });
    }

    @Override
    public Optional<Plan> handle(AddBenefitToPlanCommand command) {
        Optional<Plan> optionalPlan = planRepository.findById(command.planId());
        Optional<Benefit> optionalBenefit = benefitRepository.findById(command.benefitId());
        
        if (optionalPlan.isEmpty()) {
            throw new IllegalArgumentException("Plan not found");
        }
        
        if (optionalBenefit.isEmpty()) {
            throw new IllegalArgumentException("Benefit not found");
        }
        
        Plan plan = optionalPlan.get();
        Benefit benefit = optionalBenefit.get();
        
        plan.addBenefit(benefit);
        return Optional.of(planRepository.save(plan));
    }

    @Override
    public Optional<Plan> handle(RemoveBenefitFromPlanCommand command) {
        Optional<Plan> optionalPlan = planRepository.findById(command.planId());
        Optional<Benefit> optionalBenefit = benefitRepository.findById(command.benefitId());
        
        if (optionalPlan.isEmpty()) {
            throw new IllegalArgumentException("Plan not found");
        }
        
        if (optionalBenefit.isEmpty()) {
            throw new IllegalArgumentException("Benefit not found");
        }
        
        Plan plan = optionalPlan.get();
        Benefit benefit = optionalBenefit.get();
        
        plan.removeBenefit(benefit);
        return Optional.of(planRepository.save(plan));
    }
} 