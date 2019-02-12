package com.stackroute.Login.controller;


import com.stackroute.Login.exception.UserNameOrPasswordEmpty;
import com.stackroute.Login.exception.UserNotFoundException;
import com.stackroute.Login.model.User;
import com.stackroute.Login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController  {

    private UserService userService;
    ResponseEntity responseEntity;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserNameOrPasswordEmpty {

        try {
            if (user.getUserName() == null || user.getPassword() == null) {
//            logger.warn("Please fill in username and password");
                throw new UserNameOrPasswordEmpty("Please fill in username and password");
            } else {
                try {
                    return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
                } catch (UserNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (UserNameOrPasswordEmpty e) {
            return new ResponseEntity<String>("username or password is empty", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }
}
