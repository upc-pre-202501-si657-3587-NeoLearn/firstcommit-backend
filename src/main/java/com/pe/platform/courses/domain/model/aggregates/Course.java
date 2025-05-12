package com.pe.platform.courses.domain.model.aggregates;

import com.pe.platform.courses.domain.model.commands.CreateCourseCommand;
import com.pe.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends AuditableAbstractAggregateRoot<Course> {
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Column(unique = true)
    private String description;

    @NotBlank
    @Column(unique = true)
    private int rating;
    @NotBlank
    @Column(unique = true)
    private String category;

    public Course(CreateCourseCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.rating = command.rating();
        this.category = command.category();
    }

}
