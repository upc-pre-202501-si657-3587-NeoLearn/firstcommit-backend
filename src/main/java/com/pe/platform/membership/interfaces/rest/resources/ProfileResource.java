package com.pe.platform.membership.interfaces.rest.resources;

import java.time.LocalDateTime;

public record ProfileResource(
    Long id,
    Long userId,
    String fullName,
    String email,
    String phone,
    String bio,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
} 