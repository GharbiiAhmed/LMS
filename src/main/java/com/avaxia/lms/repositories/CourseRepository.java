package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.enumerations.Role;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    // Find courses by the user's role as a trainer
    List<Course> findByUserRole(Role role);
    Course findByName(String name); // To find a course by its name
}
