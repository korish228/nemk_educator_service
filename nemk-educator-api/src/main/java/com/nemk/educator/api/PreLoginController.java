package com.nemk.educator.api;

import com.nemk.educator.domain.Response;
import com.nemk.educator.model.User;
import com.nemk.educator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class PreLoginController {

    @Autowired
    private UserService userService;

    @Value("${upload.file.storage}")
    private String pathToStorage;

    @PostMapping(value = "/registration")
    public ResponseEntity<Response> registration(@RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationException("User has errors; Can not register user;");
        }

        Path path = Paths.get(pathToStorage + user.getEmail());
        File file = path.toFile();
        file.mkdir();
        Path pathAndCourses = Paths.get(path.toString(), "/courses");
        File file1 = pathAndCourses.toFile();
        file1.mkdir();

        User dbUser = userService.save(user);
        if (dbUser!=null){
            return new ResponseEntity<Response>(new Response("User is saved successfully"), HttpStatus.OK);
        }else {
            return null;
        }
    }

}
