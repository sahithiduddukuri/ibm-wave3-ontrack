package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.Domain.Size;
import com.stackroute.recommendationservice.service.SizeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SizeController {

    SizeServiceImpl sizeServiceImpl;

    public SizeController(SizeServiceImpl sizeServiceImpl) {
        this.sizeServiceImpl = sizeServiceImpl;
    }

    @GetMapping("size")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Size>>(sizeServiceImpl.getAllSizes(), HttpStatus.OK);
    }

    @PostMapping("size")
    public ResponseEntity<?> create(@RequestBody Size size)
    {
        ResponseEntity responseEntity;
        sizeServiceImpl.createSizeNode(size);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
