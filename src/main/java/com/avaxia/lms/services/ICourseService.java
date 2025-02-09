package com.avaxia.lms.services;

import com.avaxia.lms.entities.Course;

import java.util.List;

public interface ICourseService {
    Course saveCourse(Course course);
    Course getCourse(Long id);
    List<Course> getAllCourses();
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}
