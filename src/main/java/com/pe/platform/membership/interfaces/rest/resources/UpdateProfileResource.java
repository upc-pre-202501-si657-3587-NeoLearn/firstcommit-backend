package com.pe.platform.membership.interfaces.rest.resources;

public record UpdateProfileResource(
    String fullName,
    String email,
    String phone,
    String bio
) {
} 