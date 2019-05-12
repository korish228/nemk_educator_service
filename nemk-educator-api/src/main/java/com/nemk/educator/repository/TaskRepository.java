package com.nemk.educator.repository;

import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
//    @Modifying
//    @Query("update Task t set t.firstname = ?1 where t.id = ?3")
//    void setDocumentNameById(String documentName, String id);

    @Modifying
    @Transactional
    @Query("update Task t set t.urlToVideoFile = ?1 where t.id = ?2")
    void setVideoUrlByTaskId(String url, String taskId);
}
