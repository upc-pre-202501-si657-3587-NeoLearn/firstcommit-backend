package com.pe.platform.courses.application.internal.queryservices;

import com.pe.platform.courses.domain.model.aggregates.Course;
import com.pe.platform.courses.domain.model.queries.GetAllCoursesQuery;
import com.pe.platform.courses.domain.model.queries.GetCourseByIdQuery;
import com.pe.platform.courses.domain.services.ICourseQueryService;
import com.pe.platform.courses.infrastructure.persistence.jpa.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseQueryService implements ICourseQueryService {

    private final CourseRepository courseRepository;

    public CourseQueryService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> handle(GetAllCoursesQuery query) {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> handle(GetCourseByIdQuery query) {
        return courseRepository.findById(query.id());
    }
}
