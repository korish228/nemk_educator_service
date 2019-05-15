package com.nemk.educator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @Column(name = "course_id")
    private String id;

    private String title;
    private String titleDescription;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    private String requirements;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnore
    private List<Task> tasks;

    private Course() {
        this.tasks = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    public Course(String title, String titleDescription, String requirements, String description,User user) {
        this();
        this.title = title;
        this.titleDescription = titleDescription;
        this.requirements = requirements;
        this.description = description;
        this.user = user;
    }

    public Course(String id, String title, String titleDescription, String requirements, String description,User user) {
        this(title,titleDescription,requirements,description,user);
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public User getUser() {
        return user;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

//    @Override
//    public String toString() {
//        return "Course{" +
//                "id='" + id + '\'' +
//                ", title='" + title + '\'' +
//                ", titleDescription='" + titleDescription + '\'' +
//                ", user=" + user +
//                ", requirements='" + requirements + '\'' +
//                ", description='" + description + '\'' +
//                ", tasks=" + tasks +
//                '}';
//    }
}
