package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.domain.Product;
import com.stackroute.recommendationservice.domain.User;

import com.stackroute.recommendationservice.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    UserServiceImpl userServiceImpl;

    public ProductController(UserServiceImpl userServiceImpl)
    {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("user1")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<Collection<User>>(userServiceImpl.getAll(), HttpStatus.OK);
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

    @GetMapping("product")
    public ResponseEntity<?> getAllProducts()
    {
        return new ResponseEntity<List<Product>>(userServiceImpl.getAllproducts(), HttpStatus.OK);
    }


    @PostMapping("product")
    public ResponseEntity<?> save(@RequestBody Product product)
    {
        ResponseEntity responseEntity;
        userServiceImpl.save(product);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }






}
