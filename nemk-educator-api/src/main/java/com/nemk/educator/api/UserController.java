package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.UserViewModel;
import com.nemk.educator.db.TaskRepository;
import com.nemk.educator.db.UserRepository;
import com.nemk.educator.model.Task;
import com.nemk.educator.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<UserViewModel> all(){
        List<User> users = this.userRepository.findAll();
        List<UserViewModel> userViewModel = users.stream()
                .map(user -> mapper.convertToUserViewModel(user))
                .collect(Collectors.toList());
        return userViewModel;

    }


    @PostMapping("/registration")
    public User registerUser(@RequestBody UserViewModel userViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("User has errors; Can not register user;");
        }

        System.out.println(userViewModel);

        User user = mapper.convertToUserEntity(userViewModel);

        this.userRepository.save(user);

        return user;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.userRepository.deleteById(UUID.fromString(id));
    }
}
