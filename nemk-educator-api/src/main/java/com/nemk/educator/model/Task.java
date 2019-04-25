package com.nemk.educator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @Column(name = "task_id")
    private UUID id;
    private String title;
    private Date created;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;



    private Task() {
        this.id = UUID.randomUUID();
        this.created = new Date();
    }

    public Task(String title, Course course) {
        this();
        this.title = title;
        this.course = course;
    }

    public Task(String id, String title, Date created, Course course) {
        this(title, course);
        if (id != null) {
            this.id = UUID.fromString(id);
        }
        this.created = created;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated() {
        return created;
    }

    public Course getCourse() {
        return course;
    }
}
