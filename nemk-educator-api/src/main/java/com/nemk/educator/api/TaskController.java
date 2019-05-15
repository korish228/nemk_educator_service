package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.TaskViewModel;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import com.nemk.educator.repository.CourseRepository;
import com.nemk.educator.repository.TaskRepository;
import com.nemk.educator.repository.UserRepository;
import org.apache.tomcat.jni.Directory;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {


    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private TaskRepository taskRepository;
    private Mapper mapper;

    @Value("${upload.file.storage}")
    private String pathToStorage;

    @Autowired
    public TaskController(UserRepository userRepository, CourseRepository courseRepository, TaskRepository taskRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }





//    http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/

//    @PostMapping("/upload/{taskId}")
//    public String uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String taskId) {

//        Task task = this.taskRepository.findById(taskId).get();
//        System.out.println(file.getOriginalFilename());
//
//        Path pathBaseDir = Paths.get(pathToStorage, task.getCourse().getUser().getEmail(), "/courses" , task.getCourse().getTitle(), "/tasks", task.getTitle());
//        Path path = Paths.get(pathBaseDir.toString(),file.getOriginalFilename());
//        try {
//            taskRepository.setVideoUrlByTaskId(path.toString(), taskId);
//
//            FileUtils.cleanDirectory(pathBaseDir.toFile());
//            path.toFile().createNewFile();
//            FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
//            fileOutputStream.write(file.getBytes());
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return " Uploading been successfully uploaded";
//    }


    @GetMapping
    public List<TaskViewModel> all(){
        List<Task> tasks = taskRepository.findAll();
        List<TaskViewModel> list = tasks.stream()
                .map(task -> this.mapper.convertToTaskViewModel(task))
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping("/{id}")
    public TaskViewModel byId(@PathVariable String id){
        Task task = taskRepository.findById(id).get();
        return mapper.convertToTaskViewModel(task);
    }

    @PostMapping("/new")
    public TaskViewModel newTask(@RequestBody TaskViewModel taskViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Optional<Course> course = courseRepository.findById(taskViewModel.getCourseId());

        System.out.println(course.get());

        Path path = Paths.get(pathToStorage, course.get().getUser().getEmail(), "/courses" , course.get().getTitle(), "/tasks", taskViewModel.getTitle());
        File file = path.toFile();
        file.mkdir();

        Task task = mapper.convertToTaskEntity(taskViewModel);
        System.out.println(task);

        this.taskRepository.save(task);

        return taskViewModel;
    }
}
