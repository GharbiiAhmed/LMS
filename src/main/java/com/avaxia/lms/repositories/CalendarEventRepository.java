package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.User;

import java.util.List;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent,Long> {
    List<CalendarEvent> findByCourseId(Long courseId); // To get calendar events for a course
    List<CalendarEvent> findByUser(User user); // Add this method to find events by userId
}
