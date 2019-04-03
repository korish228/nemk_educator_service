package com.nemk.educator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    private UUID id;
    private String title;
    private Date added;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id")
    private Course course;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;


    private Task() {
        this.id = UUID.randomUUID();
        this.added = new Date();
    }



}
