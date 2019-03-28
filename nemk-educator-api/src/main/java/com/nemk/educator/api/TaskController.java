package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.db.CourseRepository;
import com.nemk.educator.db.TaskRepository;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {

    private TaskRepository taskRepository;
    private Mapper mapper;

    public TaskController(TaskRepository taskRepository, Mapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<Task> all(){
        return this.taskRepository.findAll();
    }

    @GetMapping("/byCourse/{id}")
    public List<Task> byCourse(@PathVariable String id){
        return this.taskRepository.findAllByCourseId(UUID.fromString(id));
    }
}
