package com.avaxia.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String syllabus;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Content> contentList;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CalendarEvent> calendar;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Discussion> discussions;

    @ManyToOne
    private User user;

}
