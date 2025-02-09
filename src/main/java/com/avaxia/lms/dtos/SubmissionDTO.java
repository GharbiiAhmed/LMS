package com.avaxia.lms.dtos;

import java.time.LocalDateTime;

public class SubmissionDTO {
    private Long id;
    private Long userId;
    private Long assignmentId;
    private String content;
    private String submissionDate;
    private LocalDateTime timestamp;

    // Default constructor
    public SubmissionDTO() {
    }

    // Constructor with parameters
    public SubmissionDTO(Long id, Long userId, Long assignmentId, String content, String submissionDate, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.assignmentId = assignmentId;
        this.content = content;
        this.submissionDate = submissionDate;
        this.timestamp = timestamp;
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

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
