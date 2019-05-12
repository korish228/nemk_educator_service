package com.nemk.educator.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nemk.educator.model.Course;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserViewModel {


    private String id;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private int nbCourses;

    private boolean enabled;

    private String role;

    private Date created;

    public UserViewModel() {
        this.id = UUID.randomUUID().toString();
        this.created = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNbCourses() {
        return nbCourses;
    }

    public void setNbCourses(int nbCourses) {
        this.nbCourses = nbCourses;
    }
}

