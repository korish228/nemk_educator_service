package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.db.CourseRepository;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
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

    @PostMapping("/new")
    public Course newCourse(@RequestBody Course course, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        return this.courseRepository.save(course);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.courseRepository.deleteById(UUID.fromString(id));
    }
}
