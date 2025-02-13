package com.avaxia.lms.services;
import com.avaxia.lms.entities.CalendarEvent;
import com.avaxia.lms.repositories.CalendarEventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avaxia.lms.entities.User;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class CalendarEventService implements ICalendarEventService{
    @Autowired
    private CalendarEventRepository calendarEventRepository;

    @Override
    public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent) {
        return calendarEventRepository.save(calendarEvent);
    }

    @Override
    public CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent) {
        return calendarEventRepository.save(calendarEvent);
    }

    @Override
    public void deleteCalendarEvent(Long calendarEventId) {
        calendarEventRepository.deleteById(calendarEventId);
    }

    @Override
    public List<CalendarEvent> getCalendarEventsByUser(User user) {
        return calendarEventRepository.findByUser(user);
    }

    @Override
    public List<CalendarEvent> getCalendarEventsByCourseId(Long courseId) {
        return calendarEventRepository.findByCourseId(courseId);
    }
}