package com.avaxia.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Trainer extends User {


    // Trainer-specific fields can go here, for example, assigning courses to learners.
    @OneToMany(mappedBy = "trainer")
    private Set<Course> coursesTaught;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course; // Ensure this is added


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
