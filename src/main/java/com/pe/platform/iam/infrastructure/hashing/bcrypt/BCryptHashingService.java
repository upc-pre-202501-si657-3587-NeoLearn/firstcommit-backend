package com.pe.platform.iam.infrastructure.hashing.bcrypt;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.pe.platform.iam.application.internal.outboundservices.hashing.HashingService;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used to inject the BCrypt hashing service in the {@link com.pe.platform.iam.application.internal.outboundservices.hashing.HashingService} class.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {

}