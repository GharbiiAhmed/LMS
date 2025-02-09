package com.avaxia.lms.dtos;

import com.avaxia.lms.entities.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LearnerDTO extends UserDTO {
    Set<Long> enrolledCourses; // List of course IDs the learner is enrolled in
    Set<Long> progressions; // List of progression IDs related to the learner
    Set<Long> submissions; // List of submission IDs related to the learner
    Set<Role> roles; // Handling enum role in DTO
}
