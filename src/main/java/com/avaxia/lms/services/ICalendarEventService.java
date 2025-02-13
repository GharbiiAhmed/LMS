package com.avaxia.lms.services;
import com.avaxia.lms.entities.CalendarEvent;
import com.avaxia.lms.entities.User;

import java.util.List;
public interface ICalendarEventService {
    CalendarEvent createCalendarEvent(CalendarEvent calendarEvent);
    CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent);
    void deleteCalendarEvent(Long calendarEventId);
    List<CalendarEvent> getCalendarEventsByUser(User user);
    List<CalendarEvent> getCalendarEventsByCourseId(Long courseId);
}
