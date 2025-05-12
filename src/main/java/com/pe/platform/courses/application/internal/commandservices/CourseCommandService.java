package com.pe.platform.courses.application.internal.commandservices;

import com.pe.platform.courses.domain.model.aggregates.Course;
import com.pe.platform.courses.domain.model.commands.CreateCourseCommand;
import com.pe.platform.courses.domain.services.ICourseCommandService;
import com.pe.platform.courses.infrastructure.persistence.jpa.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseCommandService implements ICourseCommandService {

     private final CourseRepository courseRepository;

     public CourseCommandService(CourseRepository courseRepository) {
         this.courseRepository = courseRepository;
     }

        @Override
        public Optional<Course> handle(CreateCourseCommand command){
            Course course = new Course(command);
            return Optional.of(courseRepository.save(course));
        }
}
