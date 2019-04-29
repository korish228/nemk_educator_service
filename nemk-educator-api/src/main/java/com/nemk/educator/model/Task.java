package com.nemk.educator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @Column(name = "task_id")
    private String id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_document_id")
    private TaskDocument videoFIle;

    private Task() {
        this.id = UUID.randomUUID().toString();
    }

    public Task(String title, TaskDocument videoFIle, Course course) {
        this();
        this.title = title;
        this.videoFIle = videoFIle;
        this.course = course;
    }

    public Task(String id, String title, TaskDocument videoFIle, Course course) {
        this(title,videoFIle, course);
        this.id = id;
    }

    public TaskDocument getVideoFIle() {
        return videoFIle;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public Course getCourse() {
        return course;
    }
}
