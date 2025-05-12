package com.pe.platform.courses.interfaces.rest.resources;

public record CourseResource(
        String name,
        String description,
        int rating,
        String category,
        long id
) {
}
