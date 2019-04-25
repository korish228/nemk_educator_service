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
        viewModel.setId(entity.getId().toString());
        viewModel.setName(entity.getName());
        viewModel.setEmail(entity.getEmail());
        viewModel.setPassword(entity.getPassword());
        viewModel.setNbCourses(entity.getCourses().size());

        return viewModel;

    }

    public CourseViewModel convertToCourseViewModel(Course entity) {
        CourseViewModel viewModel = new CourseViewModel();
        viewModel.setId(entity.getId().toString());
        viewModel.setTitle(entity.getTitle());
        viewModel.setTitleDescription(entity.getTitleDescription());
        viewModel.setUserId(entity.getUser().getId().toString());
        viewModel.setRequirements(entity.getRequirements());
        viewModel.setDescription(entity.getDescription());
        viewModel.setCreated(entity.getCreated());
        viewModel.setNbTasks(entity.getTasks().size());

        return viewModel;

    }

    public TaskViewModel convertToTaskViewModel(Task entity) {
        TaskViewModel viewModel = new TaskViewModel();
        viewModel.setId(entity.getId().toString());
        viewModel.setTitle(entity.getTitle());
        viewModel.setCreated(entity.getCreated());
        viewModel.setCourseId(entity.getCourse().getId().toString());

        return viewModel;

    }

    public User convertToUserEntity(UserViewModel viewModel) {
        Optional<User> user = this.userRepository.findById(viewModel.getId());
        User entity = new User(viewModel.getId(), viewModel.getName(), viewModel.getEmail(), viewModel.getPassword());

        return entity;
    }

    public Course convertToCourseEntity(CourseViewModel viewModel) {
        Optional<User> user = this.userRepository.findById(viewModel.getId());
        Course entity = new Course(viewModel.getId(), viewModel.getTitle(), viewModel.getTitleDescription(), viewModel.getRequirements(), viewModel.getDescription(),viewModel.getCreated(), user.get());

        return entity;
    }

    public Task convertToTaskEntity(TaskViewModel viewModel) {
        Course course = this.courseRepository.findById(viewModel.getId());
        Task entity = new Task(viewModel.getId(), viewModel.getTitle(),viewModel.getCreated(),course);

        return entity;
    }


//    public Note convertToNoteEntity(NoteViewModel viewModel) {
//        var notebook = this.notebookRepository.findById(UUID.fromString(viewModel.getNotebookId())).get();
//        var entity = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);
//
//        return entity;
//    }
}
