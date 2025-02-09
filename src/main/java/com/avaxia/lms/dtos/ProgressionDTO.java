package com.avaxia.lms.dtos;

public class ProgressionDTO {
    private Long id;
    private Long learnerId;
    private Long courseId;
    private int progressPercentage;
    private double score;

    // Default constructor
    public ProgressionDTO() {
    }

    // Constructor with parameters
    public ProgressionDTO(Long id, Long learnerId, Long courseId, int progressPercentage, double score) {
        this.id = id;
        this.learnerId = learnerId;
        this.courseId = courseId;
        this.progressPercentage = progressPercentage;
        this.score = score;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
        this.learnerId = learnerId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
