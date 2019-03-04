package com.stackroute.recommendationservice.controller;


import com.stackroute.domain.User;
import com.stackroute.recommendationservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        userService.createUser(user);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
