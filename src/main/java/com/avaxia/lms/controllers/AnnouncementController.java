package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Announcement;
import com.avaxia.lms.services.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@AllArgsConstructor
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // Create a new announcement
    @PostMapping
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.createAnnouncement(announcement);
    }

    // Update an existing announcement
    @PutMapping
    public Announcement updateAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.updateAnnouncement(announcement);
    }

    // Delete an announcement by ID
    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
    }

    // Get announcements by course ID
    @GetMapping("/course/{courseId}")
    public List<Announcement> getAnnouncementsByCourseId(@PathVariable Long courseId) {
        return announcementService.getAnnouncementsByCourseId(courseId);
    }
}
