package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Course;
import com.avaxia.lms.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.avaxia.lms.entities.enumerations.Role;

import java.util.List;

@RestController
@RequestMapping("/api/courses")  // Base URL for the course-related operations
public class CourseController {

    @Autowired
    private ICourseService courseService;

    // Create a new course
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    // Update an existing course
    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
        // Optionally, you can check if the course exists before updating
        Course updatedCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // Delete a course by ID
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // No content returned after deletion
    }

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // Get course by ID
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Not found if course is null
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Get course by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Course> getCourseByName(@PathVariable String name) {
        Course course = courseService.getCourseByName(name);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Not found if course is null
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Get courses by trainer role
    @GetMapping("/trainer-role")
    public ResponseEntity<List<Course>> getCoursesByTrainerRole(@RequestParam Role trainerRole) {
        List<Course> courses = courseService.getCoursesByTrainerRole(trainerRole);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // Get courses by learner role
    @GetMapping("/learner-role")
    public ResponseEntity<List<Course>> getCoursesByLearnerRole(@RequestParam Role learnerRole) {
        List<Course> courses = courseService.getCoursesByLearnerRole(learnerRole);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Course>> getCoursesByUserId(@PathVariable Long userId) {
        List<Course> courses = courseService.getCoursesByUserId(userId);
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Not found if no courses are found
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
