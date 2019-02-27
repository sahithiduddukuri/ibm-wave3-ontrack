package com.stackroute.routingmanager.Controller;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Service.RoutingService;
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
    public ResponseEntity responseEntity;

    @Autowired
    public RoutingManagerController(RoutingServiceImpl routingService) {
        this.routingService = routingService;
    }

    @PostMapping("/node")
    public ResponseEntity<?> addNode( @RequestBody Node node ) {

        return new ResponseEntity<>(routingService.addNode(node) , HttpStatus.OK);
    }

}
