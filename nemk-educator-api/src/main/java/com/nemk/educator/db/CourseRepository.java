package com.nemk.educator.db;

import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findAllByUserId(UUID id);
}