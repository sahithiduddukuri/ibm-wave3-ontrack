package com.stackroute.registrationservice.controller;

import com.stackroute.registrationservice.domain.User;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.service.RabbitMqProducer;
import com.stackroute.registrationservice.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class RegistrationController {

    private ResponseEntity responseEntity;
    private RegistrationService registrationService;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            registrationService.saveUser(user);
            responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
            rabbitMqProducer.produce(user);
        } catch (UserAlreadyExistsException ex1) {
            throw new UserAlreadyExistsException();
        } catch (Exception ex2) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) throws UserNotFoundException {
        try {
            registrationService.deleteUser(id);
            responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
        } catch (UserNotFoundException ex2) {
            throw new UserNotFoundException();
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") String id) throws UserNotFoundException {
        try {
            User updateUser = registrationService.updateUser(user);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {

            throw new UserNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Error !! Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser() {

        responseEntity = new ResponseEntity(registrationService.getAllUser(), HttpStatus.OK);

//        responseEntity = new ResponseEntity(registrationServiroot123
//        ce.getAllUser(),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable("userId") String userId)
    {
        User user=registrationService.getByUserId(userId);
        responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
        return responseEntity;
    }
}
