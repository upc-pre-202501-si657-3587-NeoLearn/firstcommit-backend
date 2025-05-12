package com.pe.platform.courses.domain.model.commands;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record CreateCourseCommand(String name,
                                   String description,
                                   int rating,
                                   String category) {
}