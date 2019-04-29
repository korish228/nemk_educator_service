package com.nemk.educator.model;


import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="task_document")
public class TaskDocument implements Serializable {

//    this.id = UUID.randomUUID().toString();
    @Id
    @Column(name= "task_document_id")
    private String id;

    @Column(name="name", length=100, nullable=false)
    private String name;

    @Column(name="description", length=255)
    private String description;

    @Column(name="type", length=100, nullable=false)
    private String type;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="content", nullable=false)
    private byte[] content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UserDocument [id=" + id + ", name=" + name + ", description="
                + description + ", type=" + type + "]";
    }

}