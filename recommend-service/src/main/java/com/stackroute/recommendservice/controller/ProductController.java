package com.stackroute.recommendservice.controller;

import com.stackroute.recommendservice.domain.Product;
import com.stackroute.recommendservice.domain.User;
import com.stackroute.recommendservice.repository.UserRepository;

import com.stackroute.recommendservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {
//    @Autowired
//    private UserRepository userRepository;
//
//    public void purchaseOrder()
//    {
//        User user = new User();
//        user.setName("geetha");
//        user.setPhno("7995947734");
//        user.setGender("F");
//        user.setEmailId("geethasri678@gmail.com");
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Casual shoes","Nike","white","7","$199"));
//        products.add(new Product("formal shoes","feetway","black","10","$199"));
//        userRepository.save(user);
//    }
//
//    @GetMapping("/getOrders")
//    public List<User> getPurchaseOrder()
//    {
//        return (List<User>)userRepository.findAll();
//    }
//
//    @GetMapping("/{name}")
//    public User getInfo(@PathVariable String name)
//    {
//        return userRepository.findByName(name);
//    }

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
