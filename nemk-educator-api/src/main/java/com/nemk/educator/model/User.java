package com.nemk.educator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;


//@Table(name = "user", uniqueConstraints = {
//        @UniqueConstraint(columnNames={"email"})
//})
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @NotNull
    private String username;

    @Column(unique=true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private List<Course> courses;

    private boolean enabled;
    private String role;
    private Date createdDate;

    private User() {
        this.courses = new ArrayList<>(0);
        this.id = UUID.randomUUID().toString();
        this.createdDate = new Date();
    }

    public User(String username, String email, String password, boolean enabled, String role) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;

    }

    public User(String id, String username, String email, String password, boolean enabled, String role, Date createdDate) {
        this(username, email, password, enabled, role);
        this.id = id;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public boolean isEnabled() {
        return enabled;
    }

    public String getRole() {
        return role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

