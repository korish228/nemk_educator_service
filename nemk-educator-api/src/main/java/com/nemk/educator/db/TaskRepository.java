//package com.nemk.educator.db;
//
//import com.nemk.educator.model.Course;
//import com.nemk.educator.model.Task;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.UUID;
//
//@Repository
//public interface TaskRepository extends JpaRepository<Task, UUID> {
//    List<Task> findAllByCourseId(UUID id);
//}