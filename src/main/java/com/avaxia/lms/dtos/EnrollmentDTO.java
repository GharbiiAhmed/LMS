package com.avaxia.lms.dtos;

import java.time.LocalDateTime;

public class EnrollmentDTO {
    private Long id;
    private Long userId;
    private Long courseId;
    private String status;
    private LocalDateTime enrollmentDate;

    // Default constructor
    public EnrollmentDTO() {
    }

    // Constructor with parameters
    public EnrollmentDTO(Long id, Long userId, Long courseId, String status, LocalDateTime enrollmentDate) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
