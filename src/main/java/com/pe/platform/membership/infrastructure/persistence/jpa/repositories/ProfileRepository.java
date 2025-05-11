package com.pe.platform.membership.infrastructure.persistence.jpa.repositories;

import com.pe.platform.membership.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
    Optional<Profile> findByEmail(String email);
    boolean existsByUserId(Long userId);
    boolean existsByEmail(String email);
} 