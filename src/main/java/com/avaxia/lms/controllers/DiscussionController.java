package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Discussion;
import com.avaxia.lms.services.DiscussionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussions")
@AllArgsConstructor
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping
    public Discussion createDiscussion(@RequestBody Discussion discussion) {
        return discussionService.createDiscussion(discussion);
    }

    @PutMapping
    public Discussion updateDiscussion(@RequestBody Discussion discussion) {
        return discussionService.updateDiscussion(discussion);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Discussion> getDiscussionsByCourseId(@PathVariable Long courseId) {
        return discussionService.getDiscussionsByCourseId(courseId);
    }
}