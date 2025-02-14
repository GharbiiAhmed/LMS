package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Activity;
import com.avaxia.lms.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // Create a new activity
    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    // Update an existing activity
    @PutMapping
    public Activity updateActivity(@RequestBody Activity activity) {
        return activityService.updateActivity(activity);
    }

    // Delete an activity by ID
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }

    // Get activities by course ID
    @GetMapping("/course/{courseId}")
    public List<Activity> getActivitiesByCourseId(@PathVariable Long courseId) {
        return activityService.getActivitiesByCourseId(courseId);
    }

    // Get activities by user ID
    @GetMapping("/user/{userId}")
    public List<Activity> getActivitiesByUserId(@PathVariable Long userId) {
        return activityService.getActivitiesByUserId(userId);
    }
}
