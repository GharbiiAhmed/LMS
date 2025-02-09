package com.avaxia.lms.services;

import com.avaxia.lms.entities.Lesson;

import java.util.List;

public interface ILessonService {
    Lesson saveLesson(Lesson lesson);
    Lesson getLesson(Long id);
    List<Lesson> getAllLessons();
    Lesson updateLesson(Long id, Lesson lesson);
    void deleteLesson(Long id);
}
