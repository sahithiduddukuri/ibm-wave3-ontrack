package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.Domain.Size;
import com.stackroute.recommendationservice.service.SizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SizeController {

    SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping("size")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Size>>(sizeService.getAllSizes(), HttpStatus.OK);
    }

    @PostMapping("size")
    public ResponseEntity<?> create(@RequestBody Size size)
    {
        ResponseEntity responseEntity;
        sizeService.createSizeNode(size);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
