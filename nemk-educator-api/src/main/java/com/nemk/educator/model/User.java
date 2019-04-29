package com.nemk.educator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


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
        this.courses = new ArrayList<>(0);
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String email, String password) {
        this();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String id, String name, String email, String password) {
        this(name,email,password);
        this.id = id;
    }

    public String getId() {
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

//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", courses=" + courses +
//                '}';
//    }
}

