package com.stackroute.routingmanager.Controller;

import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Domain.Vehicle;
import com.stackroute.routingmanager.Service.RoutingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(value="*")
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
        System.out.println("After RestTemplate call+++++++++++");
        routingService.locationlatlng(order);
        System.out.println("in controller{}{}{}{}{}"+routingService.locationlatlng(order));
        String[] result = new String[2];
        result = routingService.locationlatlng(order);
        double x = Double.parseDouble(result[0]);
        double y = Double.parseDouble(result[1]);
        order.setX(x);
        order.setY(y);

        return new ResponseEntity<>(routingService.saveOrder(order) , HttpStatus.OK);
    }

    @GetMapping("/route")
    public ResponseEntity<?> getRoutes(@RequestParam("slotType") String slotType,@RequestParam("date") String date) {

        System.out.println("This is in the controller^^^^^^^CONTROLLER^^^^^^^^^^^^"+routingService.optimizedRoute(slotType,date));
        return new ResponseEntity<List<Vehicle>>(routingService.optimizedRoute(slotType,date), HttpStatus.OK);
    }

}