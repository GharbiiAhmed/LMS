package com.avaxia.lms.services;
import com.avaxia.lms.entities.Course;
import com.avaxia.lms.entities.enumerations.Role;

import java.util.List;

public interface ICourseService {
    Course createCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(Long courseId);
    List<Course> getAllCourses();
    Course getCourseById(Long courseId);
    Course getCourseByName(String name);
    List<Course> getCoursesByTrainerRole(Role trainerRole);
    List<Course> getCoursesByLearnerRole(Role learnerRole);
}
