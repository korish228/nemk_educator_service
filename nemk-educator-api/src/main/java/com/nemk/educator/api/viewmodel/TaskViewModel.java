package com.nemk.educator.api.viewmodel;


//import com.nemk.educator.model.File;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class TaskViewModel {

    private String id;
    private String title;

    @NotNull
    private String courseId;

    private String urlToVideoFile;

    public TaskViewModel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getUrlToVideoFile() {
        return urlToVideoFile;
    }

    public void setUrlToVideoFile(String urlToVideoFile) {
        this.urlToVideoFile = urlToVideoFile;
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
}
