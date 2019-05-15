package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.api.viewmodel.UserViewModel;
import com.nemk.educator.domain.Response;
import com.nemk.educator.domain.UserDto;
import com.nemk.educator.exception.UnauthorizedException;
import com.nemk.educator.model.User;
import com.nemk.educator.repository.UserRepository;
import com.nemk.educator.security.JwtTokenUtill;
import com.nemk.educator.security.JwtUser;
import com.nemk.educator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private UserService userService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtill jwtTokenUtill;

    @Value("${upload.file.storage}")
    private String pathToStorage;

    @Autowired
    public UserController(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserViewModel> all(){
        List<User> users = this.userRepository.findAll();
        List<UserViewModel> userViewModel = users.stream()
                .map(user -> mapper.convertToUserViewModel(user))
                .collect(Collectors.toList());
        System.out.println(users.size());
        return userViewModel;
    }
}
