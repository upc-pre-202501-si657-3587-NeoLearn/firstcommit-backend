package com.pe.platform.courses.infrastructure.persistence.jpa.repositories;

import com.pe.platform.courses.domain.model.aggregates.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
