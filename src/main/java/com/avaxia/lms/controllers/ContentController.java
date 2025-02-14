package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Content;
import com.avaxia.lms.services.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@AllArgsConstructor
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping
    public Content createContent(@RequestBody Content content) {
        return contentService.createContent(content);
    }

    @PutMapping
    public Content updateContent(@RequestBody Content content) {
        return contentService.updateContent(content);
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Content> getContentsByCourseId(@PathVariable Long courseId) {
        return contentService.getContentsByCourseId(courseId);
    }
}
