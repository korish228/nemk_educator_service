package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import com.nemk.educator.repository.CourseRepository;
import com.nemk.educator.repository.TaskRepository;
import com.nemk.educator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {


    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private TaskRepository taskRepository;
    private Mapper mapper ;



//
//    @GetMapping("/all")
//    public List<Task> all(){
//        List<Task> tasks = taskRepository.findAll();
//        return tasks;
//    }
//
//    @PostMapping("/new")
//    public Task newTask(@RequestBody Task task, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new ValidationException();
//        }
//
//        this.taskRepository.save(task);
//
//
//
//        return task;
//    }
}
