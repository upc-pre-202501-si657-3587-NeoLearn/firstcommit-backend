package com.pe.platform.membership.infrastructure.persistence.jpa.repositories;

import com.pe.platform.membership.domain.model.entities.Payment;
import com.pe.platform.membership.domain.model.valueobjects.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findBySubscriptionId(Long subscriptionId);
    List<Payment> findByStatus(PaymentStatus status);
} 