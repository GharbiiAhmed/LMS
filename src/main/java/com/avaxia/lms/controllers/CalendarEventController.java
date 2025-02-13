package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.CalendarEvent;
import com.avaxia.lms.services.CalendarEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.avaxia.lms.entities.User;

import java.util.List;

@RestController
@RequestMapping("/calendar-events")
@AllArgsConstructor
public class CalendarEventController {

    @Autowired
    private CalendarEventService calendarEventService;

    @PostMapping
    public CalendarEvent createCalendarEvent(@RequestBody CalendarEvent calendarEvent) {
        return calendarEventService.createCalendarEvent(calendarEvent);
    }

    @PutMapping
    public CalendarEvent updateCalendarEvent(@RequestBody CalendarEvent calendarEvent) {
        return calendarEventService.updateCalendarEvent(calendarEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteCalendarEvent(@PathVariable Long id) {
        calendarEventService.deleteCalendarEvent(id);
    }

    @GetMapping("/user/{userId}")
    public List<CalendarEvent> getCalendarEventsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return calendarEventService.getCalendarEventsByUser(user);
    }

    @GetMapping("/course/{courseId}")
    public List<CalendarEvent> getCalendarEventsByCourseId(@PathVariable Long courseId) {
        return calendarEventService.getCalendarEventsByCourseId(courseId);
    }
}