package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.Domain.Category;
import com.stackroute.recommendationservice.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

    CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("category")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Category>>(categoryServiceImpl.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("category")
    public ResponseEntity<?> create(@RequestBody Category category)
    {
        ResponseEntity responseEntity;
        categoryServiceImpl.createNode(category);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
