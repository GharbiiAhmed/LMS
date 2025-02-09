package com.avaxia.lms.controller;

import com.avaxia.lms.entities.Lesson;
import com.avaxia.lms.services.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private ILessonService ILessonService;

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return ILessonService.saveLesson(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getLesson(@PathVariable Long id) {
        return ILessonService.getLesson(id);
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return ILessonService.getAllLessons();
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson lesson) {
        return ILessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        ILessonService.deleteLesson(id);
    }
}
