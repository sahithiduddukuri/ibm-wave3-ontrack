package com.stackroute.recommendationservice.controller;


import com.stackroute.domain.Product;
import com.stackroute.domain.Products;
import com.stackroute.recommendationservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {


   // Products productss;

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("product")
    public ResponseEntity<?> create(@RequestBody Product product)
    {
        ResponseEntity responseEntity;
        productService.createNode(product);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
