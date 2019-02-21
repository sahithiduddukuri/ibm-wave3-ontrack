package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.Domain.Brand;
import com.stackroute.recommendationservice.service.BrandServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BrandController {

    BrandServiceImpl brandServiceImpl;

    public BrandController(BrandServiceImpl brandServiceImpl) {
        this.brandServiceImpl = brandServiceImpl;
    }

    @GetMapping("brand")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Brand>>(brandServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping("brand")
    public ResponseEntity<?> create(@RequestBody Brand brand)
    {
        ResponseEntity responseEntity;
        brandServiceImpl.createBrandNode(brand);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
