package com.nemk.educator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


//@Table(name = "user", uniqueConstraints = {
//        @UniqueConstraint(columnNames={"email"})
//})
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @NotNull
    private UUID id;

    @NotNull
    private String name;

    @Column(unique=true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private List<Course> courses;

    private User() {
        this.id = UUID.randomUUID();
        this.courses = new ArrayList<>(0);
    }

    public User(String name, String email, String password) {
        this();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String id, String name, String email, String password) {
        this(name,email,password);
        if (id != null) {
            this.id = UUID.fromString(id);
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Course> getCourses() {
        return courses;
    }

}

