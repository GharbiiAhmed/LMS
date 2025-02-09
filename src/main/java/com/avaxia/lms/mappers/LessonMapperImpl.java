package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.LessonDTO;
import com.avaxia.lms.entities.Lesson;
import com.avaxia.lms.entities.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LessonMapperImpl {

    public LessonDTO fromLesson(Lesson lesson) {
        if (lesson == null) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();
        if (lesson.getCourse() != null) {
            lessonDTO.setCourseId(lesson.getCourse().getId());
        }

        BeanUtils.copyProperties(lesson, lessonDTO);
        return lessonDTO;
    }

    public Lesson fromLessonDTO(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        Course course = new Course();
        course.setId(lessonDTO.getCourseId()); // assuming course id is provided
        lesson.setCourse(course);
        BeanUtils.copyProperties(lessonDTO, lesson);
        return lesson;
    }
}
