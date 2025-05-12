package com.pe.platform.courses.domain.services;

import com.pe.platform.courses.domain.model.aggregates.Course;
import com.pe.platform.courses.domain.model.queries.GetAllCoursesQuery;
import com.pe.platform.courses.domain.model.queries.GetCourseByIdQuery;


import java.util.List;
import java.util.Optional;

public interface ICourseQueryService {
    List<Course> handle(GetAllCoursesQuery query);
    Optional<Course> handle(GetCourseByIdQuery query);
}
