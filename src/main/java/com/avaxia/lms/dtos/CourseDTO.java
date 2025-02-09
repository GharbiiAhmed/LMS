package com.avaxia.lms.dtos;

import java.util.List;

public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Long trainerId;
    private List<Long> assignmentIds; // List of assignment IDs (if applicable)
    private int numberOfLessons;

    // Default constructor
    public CourseDTO() {
    }

    // Constructor with parameters
    public CourseDTO(Long id, String title, String description, Long trainerId, List<Long> assignmentIds, int numberOfLessons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.trainerId = trainerId;
        this.assignmentIds = assignmentIds;
        this.numberOfLessons = numberOfLessons;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public List<Long> getAssignmentIds() {
        return assignmentIds;
    }

    public void setAssignmentIds(List<Long> assignmentIds) {
        this.assignmentIds = assignmentIds;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }
}
