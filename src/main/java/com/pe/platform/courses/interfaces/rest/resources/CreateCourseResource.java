package com.pe.platform.courses.interfaces.rest.resources;

public record CreateCourseResource(
        String name,
        String description,
        int rating,
        String category
) {
}
