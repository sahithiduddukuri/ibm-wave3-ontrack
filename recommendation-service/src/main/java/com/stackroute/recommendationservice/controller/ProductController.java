package com.stackroute.recommendationservice.controller;

import com.stackroute.rabbitmq.domain.Product;
import com.stackroute.recommendationservice.service.ProductService;
import com.stackroute.recommendationservice.service.RabbitMqConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    ProductService productService;
    @Autowired
    RabbitMqConsumer rabbitMqConsumer;

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
