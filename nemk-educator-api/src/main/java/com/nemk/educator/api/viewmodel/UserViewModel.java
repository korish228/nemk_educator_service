package com.nemk.educator.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nemk.educator.model.Course;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserViewModel {

    private String id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private int nbCourses;

    public UserViewModel() {
        this.id = UUID.randomUUID().toString();
    }
//
    public int getNbCourses() {
        return nbCourses;
    }

    public void setNbCourses(int nbCourses) {
        this.nbCourses = nbCourses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "UserViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nbCourses=" + nbCourses +
                '}';
    }
}
