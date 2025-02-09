package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.EnrollmentDTO;
import com.avaxia.lms.entities.Enrollment;
import com.avaxia.lms.entities.Course;
import com.avaxia.lms.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentMapperImpl {

    public EnrollmentDTO fromEnrollment(Enrollment enrollment) {
        if (enrollment == null) {
            return null;
        }

        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        if (enrollment.getUser() != null) {
            enrollmentDTO.setUserId(enrollment.getUser().getId());
        }
        if (enrollment.getCourse() != null) {
            enrollmentDTO.setCourseId(enrollment.getCourse().getId());
        }

        BeanUtils.copyProperties(enrollment, enrollmentDTO);
        return enrollmentDTO;
    }

    public Enrollment fromEnrollmentDTO(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = new Enrollment();
        User user = new User();
        user.setId(enrollmentDTO.getUserId()); // assuming user id is provided
        enrollment.setUser(user);

        Course course = new Course();
        course.setId(enrollmentDTO.getCourseId()); // assuming course id is provided
        enrollment.setCourse(course);

        BeanUtils.copyProperties(enrollmentDTO, enrollment);
        return enrollment;
    }
}
