package com.nemk.educator.api.viewmodel;


//import com.nemk.educator.model.File;
import com.nemk.educator.model.TaskDocument;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class TaskViewModel {

    private String id;
    private String title;
    @NotNull
    private String courseId;

    private TaskDocument videoFile;

    public TaskViewModel() {
        this.id = UUID.randomUUID().toString();
    }

    public TaskDocument getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(TaskDocument videoFile) {
        this.videoFile = videoFile;
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "TaskViewModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", courseId='" + courseId + '\'' +
                ", videoFile=" + videoFile +
                '}';
    }
}
