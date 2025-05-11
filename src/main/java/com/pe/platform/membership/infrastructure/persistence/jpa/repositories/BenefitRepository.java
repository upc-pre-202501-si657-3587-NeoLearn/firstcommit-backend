package com.pe.platform.membership.infrastructure.persistence.jpa.repositories;

import com.pe.platform.membership.domain.model.entities.Benefit;
import com.pe.platform.membership.domain.model.valueobjects.BenefitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    Optional<Benefit> findByName(String name);
    List<Benefit> findByType(BenefitType type);
} 