package com.pe.platform.membership.interfaces.rest.resources;

public record CreateProfileResource(
    Long userId,
    String fullName,
    String email,
    String phone,
    String bio
) {
} 