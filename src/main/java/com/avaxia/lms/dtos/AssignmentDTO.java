package com.avaxia.lms.dtos;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentDTO {

    private Long id;
    private String title;
    private String description;
    private Long courseId;
    private LocalDateTime dueDate;

    public AssignmentDTO(Long id, String title, String description, Long courseId, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.courseId = courseId;
        this.dueDate = dueDate;
    }
    public Long getCourseId() {
        return courseId;
    }
    public Long getId() {
        return id;
    }
}