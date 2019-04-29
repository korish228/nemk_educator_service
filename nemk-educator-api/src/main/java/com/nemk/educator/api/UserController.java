package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.UserViewModel;
import com.nemk.educator.model.User;
import com.nemk.educator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private UserRepository userRepository;
    private Mapper mapper;

    @Value("${upload.file.storage}")
    private String pathToStorage;

    @Autowired
    public UserController(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @GetMapping("/allUsers")
    public List<UserViewModel> all(){
        List<User> users = this.userRepository.findAll();
        List<UserViewModel> userViewModel = users.stream()
                .map(user -> mapper.convertToUserViewModel(user))
                .collect(Collectors.toList());
        System.out.println(users.size());
        return userViewModel;

    }


    @PostMapping("/registration")
    @ResponseStatus(value= HttpStatus.OK)
    public UserViewModel createUser(@RequestBody User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            throw new ValidationException("User has errors; Can not register user;");
        }

        Path path = Paths.get(pathToStorage + user.getEmail());
        File file = path.toFile();
        file.mkdir();
        Path pathAndCourses = Paths.get(path.toString(), "/courses");
        File file1 = pathAndCourses.toFile();
        file1.mkdir();

        this.userRepository.save(user);

        return mapper.convertToUserViewModel(user);
    }

//    @GetMapping("/deleteUser/{email}")
//    public void delete(@PathVariable String email){
//
//        User user = this.userRepository.findByEmail(email);
//
//        this.userRepository.deleteById(user.getId());
//
//        Path path = Paths.get("src/main/storage/users/" + user.getEmail());
//        File file = path.toFile();
//        file.delete();
//
//    }


}
