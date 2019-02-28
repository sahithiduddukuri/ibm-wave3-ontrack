package com.stackroute.containermanager.controller;


import com.stackroute.containermanager.domain.Order;
import com.stackroute.containermanager.domain.SlotEvaluation;
import com.stackroute.containermanager.exception.OrderAlreadyExists;
import com.stackroute.containermanager.service.ContainerService;
import com.stackroute.containermanager.service.ContainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/v1")
public class ContainerController
{
    @Autowired
    public ContainerServiceImpl containerService;
    public ResponseEntity responseEntity;

//    @Autowired
//    public ContainerController(ContainerServiceImpl containerService)
//    {
//        this.containerService = containerService;
//    }

    @PostMapping("/order")
    public ResponseEntity<?>  saveOrderAndGetSlot(@RequestBody Order order) throws OrderAlreadyExists
    {
        return new ResponseEntity<>(containerService.saveOrderAndGetSlots(order), HttpStatus.OK);
    }
}
