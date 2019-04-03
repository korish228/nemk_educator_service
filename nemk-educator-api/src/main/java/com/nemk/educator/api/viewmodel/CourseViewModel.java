package com.nemk.educator.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CourseViewModel {

    private String  id;
    private String title;
    private String titleDescription;

    @NotNull
    private String userId;

    private String requirements;
    private String description;
    private Date created;

    private int nbTasks;

    public CourseViewModel() {
        this.id = UUID.randomUUID().toString();
        this.created = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getNbTasks() {
        return nbTasks;
    }

    public void setNbTasks(int nbTasks) {
        this.nbTasks = nbTasks;
    }

    @Override
    public String toString() {
        return "CourseViewModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", titleDescription='" + titleDescription + '\'' +
                ", userId='" + userId + '\'' +
                ", requirements='" + requirements + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", nbTasks=" + nbTasks +
                '}';
    }
}
