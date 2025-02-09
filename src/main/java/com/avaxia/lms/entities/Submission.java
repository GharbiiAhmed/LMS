package com.avaxia.lms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    private String filePath; // Path to the submitted file

    @Column(nullable = false)
    private LocalDateTime submissionDate; // Date and time when the submission was made
    @ManyToOne
    @JoinColumn(name = "learner_id")
    private Learner learner;
    // Constructors, Getters, and Setters are generated by Lombok

    public String getFilePath() {
        return filePath;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public Assignment getAssignment() {
        return assignment;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
