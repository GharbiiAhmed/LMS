package com.avaxia.lms.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    @JsonIgnore
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_progress_id") // Make sure the column name matches
    @JsonIgnore
    private UserProgress userProgress;
    @ManyToOne
    @JoinColumn(name = "course_id")  // This defines the foreign key column in the database
    @JsonIgnore
    private Course course;

}