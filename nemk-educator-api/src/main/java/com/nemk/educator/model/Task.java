package com.nemk.educator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
public class Task {

    @Id
    private UUID id;
    private String title;
    private Date added;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;

    private Task() {
        this.id = UUID.randomUUID();
        this.added = new Date();
    }

    public Task(String title, Course course) {
        this();
        this.title = title;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getAdded() {
        return added;
    }

    public Course getCourse() {
        return course;
    }
}
