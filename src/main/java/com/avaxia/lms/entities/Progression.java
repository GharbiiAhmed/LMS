package com.avaxia.lms.entities;

import jakarta.persistence.*;

@Entity
public class Progression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User learner; // Learner is just a role, so we reference User

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private int completedLessons;
    private double completionPercentage; // Calculated based on total lessons

    // Constructors
    public Progression() {}

    public Progression(User learner, Course course, int completedLessons) {
        this.learner = learner;
        this.course = course;
        this.completedLessons = completedLessons;
        this.completionPercentage = calculateCompletionPercentage();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public User getLearner() { return learner; }
    public void setLearner(User learner) { this.learner = learner; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public int getCompletedLessons() { return completedLessons; }
    public void setCompletedLessons(int completedLessons) {
        this.completedLessons = completedLessons;
        this.completionPercentage = calculateCompletionPercentage();
    }

    public double getCompletionPercentage() { return completionPercentage; }
    // Removed setter for completionPercentage since it's calculated

    // Calculate completion percentage dynamically
    private double calculateCompletionPercentage() {
        return (course.getTotalLessons() > 0)
                ? ((double) completedLessons / course.getTotalLessons()) * 100
                : 0;
    }
}
