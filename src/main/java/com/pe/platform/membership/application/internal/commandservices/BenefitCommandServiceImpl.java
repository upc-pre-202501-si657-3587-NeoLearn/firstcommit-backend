package com.pe.platform.membership.application.internal.commandservices;

import com.pe.platform.iam.infrastructure.authorization.sfs.model.UserDetailsImpl;
import com.pe.platform.membership.domain.model.commands.CreateBenefitCommand;
import com.pe.platform.membership.domain.model.commands.UpdateBenefitCommand;
import com.pe.platform.membership.domain.model.entities.Benefit;
import com.pe.platform.membership.domain.services.BenefitCommandService;
import com.pe.platform.membership.infrastructure.persistence.jpa.repositories.BenefitRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BenefitCommandServiceImpl implements BenefitCommandService {

    private final BenefitRepository benefitRepository;

    public BenefitCommandServiceImpl(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    @Override
    public Optional<Benefit> handle(CreateBenefitCommand command) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        boolean hasRequiredRole = authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (hasRequiredRole) {
            Optional<Benefit> existingBenefit = benefitRepository.findByName(command.name());
            if (existingBenefit.isPresent()) {
                throw new IllegalStateException("A benefit with that name already exists");
            }
            
            Benefit benefit = new Benefit(command.name(), command.description(), command.type());
            return Optional.of(benefitRepository.save(benefit));
        } else {
            throw new SecurityException("Only admins can create a benefit");
        }
    }

    @Override
    public Optional<Benefit> handle(UpdateBenefitCommand command) {
        return benefitRepository.findById(command.id())
                .map(benefit -> {
                    // Update only the fields that are provided
                    if (command.name() != null) {
                        // Check if the new name is already used by another benefit
                        benefitRepository.findByName(command.name())
                                .ifPresent(existingBenefit -> {
                                    if (!existingBenefit.getId().equals(command.id())) {
                                        throw new IllegalStateException("A benefit with that name already exists");
                                    }
                                });
                        
                        benefit.setName(command.name());
                    }
                    
                    if (command.description() != null) {
                        benefit.setDescription(command.description());
                    }
                    
                    if (command.type() != null) {
                        benefit.setType(command.type());
                    }
                    
                    return benefitRepository.save(benefit);
                });
    }
} 