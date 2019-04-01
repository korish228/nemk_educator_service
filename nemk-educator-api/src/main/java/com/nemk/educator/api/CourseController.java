package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.CourseViewModel;
import com.nemk.educator.db.CourseRepository;
import com.nemk.educator.db.UserRepository;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private Mapper mapper;

    public CourseController(CourseRepository courseRepository, UserRepository userRepository, Mapper mapper) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<CourseViewModel> all(){

        List<Course> courses = courseRepository.findAll();

        List<CourseViewModel> list = courses.stream()
                .map(course -> this.mapper.convertToCourseViewModel(course))
                .collect(Collectors.toList());
        return list;
    }


    @GetMapping("/byUser/{id}")
    public List<CourseViewModel> allByUserId(@PathVariable String id){

        List<Course> courseList = this.courseRepository.findAllByUserId(UUID.fromString(id));
//
//        if (courseList.size() == 0){
//            throw new EntityNotFoundException();
//        }

        List<CourseViewModel> viewModelList = courseList.stream()
                .map(course -> this.mapper.convertToCourseViewModel(course))
                .collect(Collectors.toList());
        return viewModelList;
    }

    @PostMapping("/new")
    public Course newCourse(@RequestBody CourseViewModel courseViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Course course = this.mapper.convertToCourseEntity(courseViewModel);

        this.courseRepository.save(course);

        return course;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.courseRepository.deleteById(UUID.fromString(id));
    }
}
