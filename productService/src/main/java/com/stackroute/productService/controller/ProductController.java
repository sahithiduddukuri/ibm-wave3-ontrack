package com.stackroute.productService.controller;


import com.stackroute.productService.domain.Product;
import com.stackroute.productService.exceptions.ProductAlreadyExistsException;
import com.stackroute.productService.exceptions.ProductAlreadyUpdatedExcetion;
import com.stackroute.productService.exceptions.ProductIdNotFoundException;
import com.stackroute.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class ProductController {
    private ProductService productService;
    ResponseEntity responseEntity;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ResponseEntity<?> saveTrack(@RequestBody Product product) throws ProductAlreadyExistsException {


        productService.saveProduct(product);
        responseEntity=new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);


        return responseEntity;

    }

    @PutMapping("product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) throws ProductAlreadyUpdatedExcetion {


        productService.updateProduct(product);
        responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);

        return responseEntity;

    }
    @GetMapping("product")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("product/name")
    public ResponseEntity<?> query(@RequestParam("shoes") String query) {
        productService.searchProduct(query);
        System.out.println(productService.searchProduct(query));
        responseEntity=new ResponseEntity(productService.searchProduct(query),HttpStatus.OK);
        return responseEntity;
    }
}
