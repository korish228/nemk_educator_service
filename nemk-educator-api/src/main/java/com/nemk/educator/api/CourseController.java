package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.CourseViewModel;
import com.nemk.educator.domain.Response;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.User;
import com.nemk.educator.repository.CourseRepository;
import com.nemk.educator.repository.UserRepository;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private Mapper mapper;
    @Value("${upload.file.storage}")
    private String pathToStorage;

    @Autowired
    public CourseController(UserRepository userRepository, CourseRepository courseRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public CourseViewModel byId(@PathVariable String id){
        Course course = courseRepository.findById(id).get();
        return mapper.convertToCourseViewModel(course);
    }


    @GetMapping
    public List<CourseViewModel> all(){
        List<Course> courses = courseRepository.findAll();
        List<CourseViewModel> list = courses.stream()
                .map(course -> this.mapper.convertToCourseViewModel(course))
                .collect(Collectors.toList());
        return list;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable String id) {

        Course course = this.courseRepository.findById(id).get();
        this.courseRepository.deleteById(id);

        try {
            Path path = Paths.get(pathToStorage,course.getUser().getEmail(), "/courses" , course.getTitle());
            System.out.println(path.toString());
            File file = path.toFile();
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Response>(new Response("Course been deleted successfully"), HttpStatus.OK);
    }

    @PostMapping("/new")
    public CourseViewModel newCourse(@RequestBody CourseViewModel courseViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Course course= mapper.convertToCourseEntity(courseViewModel);
        this.courseRepository.save(course);

        Optional<User> user = this.userRepository.findById(courseViewModel.getUserId());

        System.out.println(user.get());

        Path path = Paths.get(pathToStorage,user.get().getEmail(), "/courses" , courseViewModel.getTitle());
        File file = path.toFile();
        file.mkdir();

        Path pathAndCourses = Paths.get(path.toString(), "/tasks");
        File file1 = pathAndCourses.toFile();
        file1.mkdir();



        return courseViewModel;
    }

}
