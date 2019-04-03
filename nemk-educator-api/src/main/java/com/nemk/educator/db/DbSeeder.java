package com.nemk.educator.db;

import com.nemk.educator.model.Course;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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

        User user = new User("Dmytro","korish","999");
        User user3 = new User("0563aa22-2280-4849-a7e3-0dbe68e8f276", "test","test","test");

        this.userRepository.save(user);
        this.userRepository.save(user3);

        Course course = new Course("Phyton","Lalalalallalalalalall","english","lalala",user);
//        Course course1 = new Course("Java","Lala","french","lalala",user1);
        Course course2 = new Course("test","This coursekcnds hsfd vfnshv djkfvhfnhvhf","test","test",user3);


        this.courseRepository.save(course);
        this.courseRepository.save(course2);

        Task task = new Task("Overview",course);
        Task task1 = new Task("Overview1",course);
        Task task2 = new Task("Overview2",course);
        Task task3 = new Task("Overview2",course2);

        this.taskRepository.save(task);
        this.taskRepository.save(task1);
        this.taskRepository.save(task2);
        this.taskRepository.save(task3);

        System.out.println("Initialized database");
    }
}