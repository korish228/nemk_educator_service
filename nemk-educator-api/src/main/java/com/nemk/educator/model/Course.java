package com.nemk.educator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "course")
public class Course {

    @Id
    private UUID id;
    private String title;
    private String titleDescription;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
    private String requirements;
    private String description;
    private Date created;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    @JsonIgnore
    private List<Task> tasks;

    private Course() {
        this.id = UUID.randomUUID();
        this.tasks = new ArrayList<>();
    }

    public Course(String title, String titleDescription, String requirements, String description,User user) {
        this();
        this.title = title;
        this.titleDescription = titleDescription;
        this.requirements = requirements;
        this.description = description;
        this.created = new Date();
        this.user = user;
    }

    public Course(String id, String title, String titleDescription, String requirements, String description,Date created,User user) {
        this(title,titleDescription,requirements,description,user);
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

    public Date getCreated() {
        return created;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
