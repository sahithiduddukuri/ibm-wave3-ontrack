package com.stackroute.deliverymanager.Controller;

import com.stackroute.deliverymanager.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping( value = "/api/v1")
public class DeliveryManagerController {


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/slot")
    public ResponseEntity<?>  saveSlot(@RequestBody Order order)
    {
        String uri = "http://localhost:8084/api/v1/order";
        System.out.println("order" + order);
        SlotEvaluation result = restTemplate.postForObject(uri,order,SlotEvaluation.class);
        System.out.println(result);
        return new ResponseEntity<SlotEvaluation>(result,HttpStatus.OK);
    }

    @PostMapping("/slotbooked")
    public ResponseEntity<?> getSelectedSlot(@RequestBody SelectedSlot selectedSlot)
    {
        String uri = "http://localhost:8084/api/v1/bookedslot";
        System.out.println("select slot"+ selectedSlot);
        SlotEvaluation result = restTemplate.postForObject(uri,selectedSlot,SlotEvaluation.class);
        System.out.println(result);
        return new ResponseEntity<SlotEvaluation>(result,HttpStatus.OK);

    }



}

