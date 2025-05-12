package com.pe.platform.courses.interfaces.rest;

import com.pe.platform.courses.application.internal.commandservices.CourseCommandService;
import com.pe.platform.courses.application.internal.queryservices.CourseQueryService;
import com.pe.platform.courses.domain.model.queries.GetAllCoursesQuery;
import com.pe.platform.courses.domain.model.queries.GetCourseByIdQuery;
import com.pe.platform.courses.infrastructure.persistence.jpa.repositories.CourseRepository;
import com.pe.platform.courses.interfaces.rest.resources.CourseResource;
import com.pe.platform.courses.interfaces.rest.resources.CreateCourseResource;
import com.pe.platform.courses.interfaces.rest.transform.CourseCommandFromResourceAssembler;
import com.pe.platform.courses.interfaces.rest.transform.CourseResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CourseController
 * <p>
 *     This controller is responsible for handling courses requests.
 *     <ul>
 *         <li>POST /api/v1/courses/</li>
 *         <li>POST /api/v1/courses/</li>
 *     </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/course", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Course", description = "Course Endpoints")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseCommandService courseCommandService;
    private final CourseQueryService courseQueryService;

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseCommandService courseCommandService, CourseQueryService courseQueryService) {
        this.courseRepository = courseRepository;
        this.courseCommandService = courseCommandService;
        this.courseQueryService = courseQueryService;
    }

    /**
     * handles the course creation request.
     * @param courseResource the course resource to be created.
     * @return the created course.
     */
    @PostMapping("/create")
    public ResponseEntity<CourseResource> createCourse(@RequestBody CreateCourseResource courseResource) {
        var courseCommand = CourseCommandFromResourceAssembler.toCommandFromResource(courseResource);
        var course = courseCommandService.handle(courseCommand);
        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var courseResourceResponse = CourseResourceFromEntityAssembler.toResourceFromEntity(course.get());
        return ResponseEntity.ok(courseResourceResponse);
    }

    /**
     * handles the course retrieval request.
     * @param query the course query that contains id to be retrieved.
     * @return the retrieved course.
     */
    @GetMapping("/get/{courseId}")
    public ResponseEntity<CourseResource> getCourseById(@RequestParam GetCourseByIdQuery query) {
        var course = courseQueryService.handle(query);
        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var courseResourceResponse = CourseResourceFromEntityAssembler.toResourceFromEntity(course.get());
        return ResponseEntity.ok(courseResourceResponse);
    }

    /**
     * handles the course retrieval request.
     * @return the retrieved course.
     */
    @GetMapping
    public ResponseEntity<List<CourseResource>> getAllCourses() {
        var query = new GetAllCoursesQuery();
        var courses = courseQueryService.handle(query);
        var courseResources = courses.stream()
                .map(CourseResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(courseResources);
    }

    /**
     * handles the course deletion request.
     * @param courseId the course id to be deleted.
     * @return the deleted course.
     */
    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        var course = courseRepository.findById(courseId);
        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        courseRepository.delete(course.get());
        return ResponseEntity.noContent().build();
    }
}