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

    private String urlToVideoFile;

    private Task() {
        this.id = UUID.randomUUID().toString();
    }

    public Task(String title,String urlToVideoFile, Course course) {
        this();
        this.title = title;
        this.course = course;
        this.urlToVideoFile = urlToVideoFile;
    }

    public Task(String id, String title,String urlToVideoFile, Course course) {
        this(title,urlToVideoFile, course);
        this.id = id;
    }

    public String getUrlToVideoFile() {
        return urlToVideoFile;
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
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "id='" + id + '\'' +
//                ", title='" + title + '\'' +
//                ", course=" + course +
//                ", videoFIle=" + videoFIle +
//                '}';
//    }
}
