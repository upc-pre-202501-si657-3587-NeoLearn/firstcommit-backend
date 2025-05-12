package com.pe.platform.courses.domain.services;

import com.pe.platform.courses.domain.model.aggregates.Course;
import com.pe.platform.courses.domain.model.commands.CreateCourseCommand;

import java.util.Optional;

public interface ICourseCommandService {
    Optional<Course> handle(CreateCourseCommand command);
}
