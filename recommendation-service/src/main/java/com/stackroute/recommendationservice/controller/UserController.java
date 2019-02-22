package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.Domain.User;
import com.stackroute.recommendationservice.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userServiceImpl.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        userServiceImpl.createUser(user);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
