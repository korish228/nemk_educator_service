package com.nemk.educator.repository;

import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    Course findById(String id);

}
