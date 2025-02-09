package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.AssignmentDTO;
import com.avaxia.lms.entities.Assignment;
import com.avaxia.lms.entities.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AssignmentMapperImpl {

    /*
    public AssignmentDTO fromAssignment(Assignment assignment) {

        if (assignment == null) {
            return null;
        }

        AssignmentDTO assignmentDTO = new AssignmentDTO();
        if (assignment.getCourse() != null) {
            assignmentDTO.setCourseId(assignment.getCourse().getId());
        }

        BeanUtils.copyProperties(assignment, assignmentDTO);
        return assignmentDTO;
    }

     */
    public AssignmentDTO fromAssignment(Assignment assignment) {
        if (assignment == null) {
            return null;
        }

        AssignmentDTO assignmentDTO = new AssignmentDTO(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getCourse() != null ? assignment.getCourse().getId() : null,
                assignment.getDueDate()
        );

        return assignmentDTO;
    }
    public Assignment fromAssignmentDTO(AssignmentDTO assignmentDTO) {
        Assignment assignment = new Assignment();
        Course course = new Course();
        course.setId(assignmentDTO.getCourseId()); // assuming course id is provided
        assignment.setCourse(course);
        BeanUtils.copyProperties(assignmentDTO, assignment);
        return assignment;
    }
}
