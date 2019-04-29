package com.nemk.educator.repository;

import com.nemk.educator.api.viewmodel.CourseViewModel;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

    CourseViewModel save(CourseViewModel courseViewModel);

}
