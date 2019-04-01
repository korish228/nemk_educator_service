package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.CourseViewModel;
import com.nemk.educator.api.viewmodel.TaskViewModel;
import com.nemk.educator.db.CourseRepository;
import com.nemk.educator.db.TaskRepository;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<TaskViewModel> all(){

        List<Task> allTasks = this.taskRepository.findAll();

        List<TaskViewModel> taskViewModels = allTasks.stream()
                .map(task -> this.mapper.convertToTaskViewModel(task))
                .collect(Collectors.toList());

        return taskViewModels;
    }

    @GetMapping("/byCourse/{id}")
    public List<TaskViewModel> byCourse(@PathVariable String id){

        List<Task> taskList = this.taskRepository.findAllByCourseId(UUID.fromString(id));

        List<TaskViewModel> viewModelList = taskList.stream()
                .map(task -> this.mapper.convertToTaskViewModel(task))
                .collect(Collectors.toList());
        return viewModelList;

    }

    @PostMapping("/new")
    public Task newTask(@RequestBody TaskViewModel taskViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Task task = this.mapper.convertToTaskEntity(taskViewModel);

        this.taskRepository.save(task);

        return task;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.taskRepository.deleteById(UUID.fromString(id));
    }
}
