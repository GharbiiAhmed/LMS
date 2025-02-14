package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.UserProgress;
import com.avaxia.lms.services.UserProgressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-progress")
@AllArgsConstructor
public class UserProgressController {

    @Autowired
    private UserProgressService userProgressService;

    @PostMapping
    public UserProgress createUserProgress(@RequestBody UserProgress userProgress) {
        return userProgressService.createUserProgress(userProgress);
    }

    @PutMapping
    public UserProgress updateUserProgress(@RequestBody UserProgress userProgress) {
        return userProgressService.updateUserProgress(userProgress);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProgress(@PathVariable Long id) {
        userProgressService.deleteUserProgress(id);
    }

    @GetMapping("/{userId}/{courseId}")
    public UserProgress getUserProgressByUserIdAndCourseId(@PathVariable Long userId, @PathVariable Long courseId) {
        return userProgressService.getUserProgressByUserIdAndCourseId(userId, courseId);
    }
}