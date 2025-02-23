package com.avaxia.lms.services;
import com.avaxia.lms.entities.Course;
import com.avaxia.lms.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avaxia.lms.entities.enumerations.Role;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j

public class CourseService implements ICourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }



    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public List<Course> getCoursesByTrainerRole(Role trainerRole) {
        return courseRepository.findByUserRole(trainerRole);
    }

    @Override
    public List<Course> getCoursesByLearnerRole(Role learnerRole) {
        return courseRepository.findByUserRole(learnerRole);
    }

    @Override
    public List<Course> getCoursesByUserId(Long userId) {
        return courseRepository.getCoursesByUserId(userId);
    }
}