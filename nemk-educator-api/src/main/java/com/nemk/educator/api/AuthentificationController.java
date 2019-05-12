package com.nemk.educator.api;

import com.nemk.educator.Mapper;
import com.nemk.educator.domain.UserDto;
import com.nemk.educator.exception.UnauthorizedException;
import com.nemk.educator.model.User;
import com.nemk.educator.security.JwtTokenUtill;
import com.nemk.educator.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthentificationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtill jwtTokenUtill;
    @Autowired
    private Mapper mapper;



    @PostMapping(value = "/login" )
    public ResponseEntity<UserDto> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtill.generateToken(userDetails);
            response.setHeader("Token" , token);
            return new ResponseEntity<UserDto>(new UserDto(userDetails.getUser(), token), HttpStatus.OK);

        }catch (Exception e){
            System.out.println("try 7");
            throw new UnauthorizedException(e.getMessage());
        }

    }


}
