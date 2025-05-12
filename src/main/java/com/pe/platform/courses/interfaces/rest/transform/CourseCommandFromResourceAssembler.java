package com.pe.platform.courses.interfaces.rest.transform;

import com.pe.platform.courses.domain.model.commands.CreateCourseCommand;
import com.pe.platform.courses.interfaces.rest.resources.CreateCourseResource;
import com.pe.platform.iam.domain.model.commands.SignInCommand;
import com.pe.platform.iam.interfaces.rest.resources.SignInResource;

public class CourseCommandFromResourceAssembler {
    public static CreateCourseCommand toCommandFromResource(CreateCourseResource courseResource) {
        return new CreateCourseCommand(
                courseResource.name(),
                courseResource.description(),
                courseResource.rating(),
                courseResource.category()
        );
    }
}