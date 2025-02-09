package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.CourseDTO;
import com.avaxia.lms.entities.Course;
import com.avaxia.lms.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CourseMapperImpl {

    public CourseDTO fromCourse(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        if (course.getTrainer() != null) {
            courseDTO.setTrainerId(course.getTrainer().getId());
        }

        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    public Course fromCourseDTO(CourseDTO courseDTO) {
        Course course = new Course();
        User trainer = new User();
        trainer.setId(courseDTO.getTrainerId()); // assuming trainer id is provided
        course.setTrainer(trainer);
        BeanUtils.copyProperties(courseDTO, course);
        return course;
    }
}
