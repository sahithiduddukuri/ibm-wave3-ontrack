package com.stackroute.containermanager.controller;


import com.stackroute.containermanager.domain.Order;
import com.stackroute.containermanager.domain.Product;
import com.stackroute.containermanager.domain.SelectedSlot;
import com.stackroute.containermanager.domain.SlotEvaluation;
import com.stackroute.containermanager.exception.OrderAlreadyExists;
import com.stackroute.containermanager.exception.OrderNotFound;
import com.stackroute.containermanager.service.ContainerService;
import com.stackroute.containermanager.service.ContainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(value= "*")
@Controller
@RequestMapping(value = "/api/v1")
public class ContainerController
{
    public ContainerController() {
    }

    public ContainerServiceImpl containerService;
    public ResponseEntity responseEntity;

    @Autowired
    public ContainerController(ContainerServiceImpl containerService)
    {
        this.containerService = containerService;
    }

    @PostMapping("/order")
    public ResponseEntity<?>  saveOrderAndGetSlot(@RequestBody Order order) throws OrderAlreadyExists
    {
        return new ResponseEntity<>(containerService.saveOrderAndGetSlots(order), HttpStatus.OK);
    }

    @PostMapping("/bookedslot")
    public  ResponseEntity<?> selectedSlot(@RequestBody SelectedSlot selectedSlot) throws OrderNotFound , OrderAlreadyExists {

        return new ResponseEntity<>(containerService.saveSelecteSlots(selectedSlot),HttpStatus.OK);
    }

    @GetMapping("/getSlot")
    public ResponseEntity<?> getSlot(@RequestParam("date") String date) throws OrderNotFound
    {
        try {
            return new ResponseEntity <SlotEvaluation>(containerService.getSlotByDate(date), HttpStatus.OK);
        }
        catch(Error err)
        {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
