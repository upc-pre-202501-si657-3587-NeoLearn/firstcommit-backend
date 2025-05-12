package com.pe.platform.courses.interfaces.rest.transform;

import com.pe.platform.courses.domain.model.aggregates.Course;
import com.pe.platform.courses.interfaces.rest.resources.CourseResource;

import java.util.List;


public class CourseResourceFromEntityAssembler {
    public static CourseResource toResourceFromEntity(Course course) {
        return new CourseResource(course.getName(),
                course.getDescription(),
                course.getRating(),
                course.getCategory(),
                course.getId());
    }
}

