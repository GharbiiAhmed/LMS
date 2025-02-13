package com.avaxia.lms.services;
import com.avaxia.lms.entities.Assignment;

import java.util.List;
public interface IAssignmentService {
    Assignment createAssignment(Assignment assignment);
    Assignment updateAssignment(Assignment assignment);
    void deleteAssignment(Long assignmentId);
    List<Assignment> getAssignmentsByCourseId(Long courseId);

}
