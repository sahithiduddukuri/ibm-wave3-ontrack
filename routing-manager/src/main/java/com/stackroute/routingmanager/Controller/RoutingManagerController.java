package com.stackroute.routingmanager.Controller;

import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Service.RoutingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( value = "api/v1")
public class RoutingManagerController {

    public RoutingServiceImpl routingService;
    @Autowired
    public RoutingManagerController(RoutingServiceImpl routingService)
    {
        this.routingService = routingService;
    }

    @PostMapping("/order")
    public ResponseEntity<?> saveNode( @RequestBody Order order) {

        return new ResponseEntity<>(routingService.saveOrder(order) , HttpStatus.OK);
    }

    @GetMapping("/route")
    public ResponseEntity<?> getRoutes() {

        return new ResponseEntity<>(routingService.optimizedRoute(), HttpStatus.OK);
    }

}
