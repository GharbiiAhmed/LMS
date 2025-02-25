package com.avaxia.lms.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    private Double percentageCompleted;

    @OneToMany(mappedBy = "userProgress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Grade> grades;

}