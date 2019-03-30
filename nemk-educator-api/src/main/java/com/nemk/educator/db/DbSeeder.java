package com.nemk.educator.db;

import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "nemk.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {
    private CourseRepository courseRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public DbSeeder(CourseRepository courseRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
//         Remove all existing entities

        this.taskRepository.deleteAll();
        this.courseRepository.deleteAll();
        this.userRepository.deleteAll();

//        User user = new User("Dmytro","korish","999");
//        User user1 = new User("Danya","danj","22e1");
//        User user2 = new User("Alex","Alel","3dd3");
//        this.userRepository.save(user);
//        this.userRepository.save(user1);
//        this.userRepository.save(user2);
//
//        Course course = new Course("Phyton","","English","lalala",user);
//        Course course1 = new Course("Java","Lala","Fraench","lalala",user1);
//
//        this.courseRepository.save(course);
//        this.courseRepository.save(course1);
//
//        Task task = new Task("Overview",course);
//        Task task1 = new Task("Overview1",course);
//        Task task2 = new Task("Overview2",course);
//        Task task3 = new Task("Overview2",course1);
//
//        this.taskRepository.save(task);
//        this.taskRepository.save(task1);
//        this.taskRepository.save(task2);
//        this.taskRepository.save(task3);

        System.out.println("Initialized database");
    }
}