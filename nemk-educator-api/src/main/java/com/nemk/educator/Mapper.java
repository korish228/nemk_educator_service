package com.nemk.educator;

import com.nemk.educator.api.viewmodel.CourseViewModel;
import com.nemk.educator.api.viewmodel.TaskViewModel;
import com.nemk.educator.api.viewmodel.UserViewModel;
import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;
import com.nemk.educator.repository.CourseRepository;
import com.nemk.educator.repository.TaskRepository;
import com.nemk.educator.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class Mapper {
    private CourseRepository courseRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public Mapper(CourseRepository courseRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public UserViewModel convertToUserViewModel(User entity) {
        UserViewModel viewModel = new UserViewModel();
        viewModel.setId(entity.getId());
        viewModel.setUsername(entity.getUsername());
        viewModel.setEmail(entity.getEmail());
        viewModel.setPassword(entity.getPassword());
        viewModel.setNbCourses(entity.getCourses().size());
        viewModel.setEnabled(entity.isEnabled());
        viewModel.setRole(entity.getRole());
        viewModel.setCreated(entity.getCreatedDate());

        return viewModel;

    }

    public User convertToUserEntity(UserViewModel viewModel) {
        User user = this.userRepository.findById(viewModel.getId()).get();
        User entity = new User(viewModel.getId(), viewModel.getUsername(), viewModel.getEmail(),
                viewModel.getPassword(), viewModel.isEnabled(), viewModel.getRole(), viewModel.getCreated());

        return entity;
    }


    public CourseViewModel convertToCourseViewModel(Course entity) {
        CourseViewModel viewModel = new CourseViewModel();
        viewModel.setId(entity.getId());
        viewModel.setTitle(entity.getTitle());
        viewModel.setTitleDescription(entity.getTitleDescription());
        viewModel.setUserId(entity.getUser().getId());
        viewModel.setRequirements(entity.getRequirements());
        viewModel.setDescription(entity.getDescription());
        viewModel.setNbTasks(entity.getTasks().size());

        return viewModel;

    }

    public Course convertToCourseEntity(CourseViewModel viewModel) {
        User user = this.userRepository.findById(viewModel.getUserId()).get();


        Course entity = new Course(viewModel.getId(),viewModel.getTitle(), viewModel.getTitleDescription(),
                                     viewModel.getRequirements(),viewModel.getDescription(),user);
        return entity;
    }

    public TaskViewModel convertToTaskViewModel(Task entity) {
        TaskViewModel viewModel = new TaskViewModel();
        viewModel.setId(entity.getId());
        viewModel.setTitle(entity.getTitle());
        viewModel.setUrlToVideoFile(entity.getUrlToVideoFile());
        viewModel.setCourseId(entity.getCourse().getId());

        return viewModel;

    }


    public Task convertToTaskEntity(TaskViewModel viewModel) {
        Optional<Course> course = this.courseRepository.findById(viewModel.getCourseId());
        Task entity = new Task(viewModel.getId(), viewModel.getTitle(),viewModel.getUrlToVideoFile() ,course.get());

        return entity;
    }


//    public Note convertToNoteEntity(NoteViewModel viewModel) {
//        var notebook = this.notebookRepository.findById(UUID.fromString(viewModel.getNotebookId())).get();
//        var entity = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);
//
//        return entity;
//    }
}
