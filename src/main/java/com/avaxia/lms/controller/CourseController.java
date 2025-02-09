package com.avaxia.lms.controller;

import com.avaxia.lms.entities.Course;
import com.avaxia.lms.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService ICourseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return ICourseService.saveCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return ICourseService.getCourse(id);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return ICourseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return ICourseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        ICourseService.deleteCourse(id);
    }
}
