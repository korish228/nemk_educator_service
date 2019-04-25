package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.CourseViewModel;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import com.nemk.educator.repository.CourseRepository;
import com.nemk.educator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

//    private UserRepository userRepository;
//    private CourseRepository courseRepository;
//    private Mapper mapper;
//
//    @Autowired
//    public CourseController(UserRepository userRepository, CourseRepository courseRepository, Mapper mapper) {
//        this.userRepository = userRepository;
//        this.courseRepository = courseRepository;
//        this.mapper = mapper;
//    }
//
//    @GetMapping("/all")
//    public List<CourseViewModel> all(){
//
//        List<Course> courses = courseRepository.findAll();
//
//        List<CourseViewModel> list = courses.stream()
//                .map(course -> this.mapper.convertToCourseViewModel(course))
//                .collect(Collectors.toList());
//        return list;
//    }
//
//    @PostMapping("/new")
//    public CourseViewModel newCourse(@RequestBody CourseViewModel courseViewModel, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new ValidationException();
//        }
//
//        String currentUserId = courseViewModel.getUserId();
//        Optional<User> user1 = this.userRepository.findById(currentUserId);
//
//        Path path = Paths.get("src/main/storage/users/" + user1.get().getEmail() + "/courses");
//
//        File file = path.toFile();
//        file.mkdir();
//
//        Course course = mapper.convertToCourseEntity(courseViewModel);
//        this.courseRepository.save(course);
//
//
//        return courseViewModel;
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable String id) {
//        this.courseRepository.deleteById(Long.parseLong(id));
//    }



}
