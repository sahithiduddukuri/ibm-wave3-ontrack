package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.Domain.Product;
import com.stackroute.recommendationservice.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("product")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Product>>(productServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping("product")
    public ResponseEntity<?> create(@RequestBody Product product)
    {
        ResponseEntity responseEntity;
        productServiceImpl.createNode(product);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
