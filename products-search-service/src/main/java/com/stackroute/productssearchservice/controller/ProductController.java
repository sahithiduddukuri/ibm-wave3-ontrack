package com.stackroute.productssearchservice.controller;

import com.stackroute.productssearchservice.domain.Products;
import com.stackroute.productssearchservice.exception.ProductAlreadyExistsException;
import com.stackroute.productssearchservice.exception.ProductDoesNotExistsException;
import com.stackroute.productssearchservice.repository.ProductRepository;
import com.stackroute.productssearchservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    ProductService productService;
    private ResponseEntity<?> responseEntity;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }



    @PostMapping("/search-product")
    public ResponseEntity<?> saveGenre(@RequestBody Products products){
        try
        {
            return new ResponseEntity<Products>(productService.saveProduct(products), HttpStatus.OK);
        }
        catch (ProductAlreadyExistsException e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/search-product/{productName}")
    public ResponseEntity<?>searchGenreByStartsWith(@PathVariable("productName") String productName){
        try {
            return new ResponseEntity<List<Products>>(productService.getAllProductByStartswith(productName), HttpStatus.OK);
        }
        catch (ProductDoesNotExistsException e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
