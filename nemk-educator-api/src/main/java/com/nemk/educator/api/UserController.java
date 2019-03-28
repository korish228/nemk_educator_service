package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.db.TaskRepository;
import com.nemk.educator.db.UserRepository;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private UserRepository userRepository;
    private Mapper mapper;

    public UserController(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<User> all(){

        return this.userRepository.findAll();
    }

    @PostMapping("/registration")
    public User registerUser(@RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors() && this.userRepository.findAll().contains(user)){
            throw new ValidationException("User has errors; Can not register user;");
        }
        return this.userRepository.save(user);

    }
}
