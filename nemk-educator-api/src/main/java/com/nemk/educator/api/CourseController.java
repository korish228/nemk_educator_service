package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.db.CourseRepository;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private CourseRepository courseRepository;
    private Mapper mapper;

    public CourseController(CourseRepository courseRepository, Mapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<Course> all(){
        return courseRepository.findAll();
    }

//    need to map to view that which below this comment

    @GetMapping("/byUser/{id}")
    public List<Course> byUserId(@PathVariable String id){

        return courseRepository.findAllByUserId(UUID.fromString(id));
    }
}
