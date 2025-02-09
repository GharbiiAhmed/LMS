package com.avaxia.lms.dtos;

public class LessonDTO {
    private Long id;
    private String title;
    private String content;
    private Long courseId;

    // Default constructor
    public LessonDTO() {
    }

    // Constructor with parameters
    public LessonDTO(Long id, String title, String content, Long courseId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.courseId = courseId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
