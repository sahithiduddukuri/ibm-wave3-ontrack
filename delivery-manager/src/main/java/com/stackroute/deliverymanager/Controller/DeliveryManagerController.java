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
@CrossOrigin(value = "*")
@RequestMapping( value = "/api/v1")
public class DeliveryManagerController {


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/slot")
    public ResponseEntity<?>  saveSlot(@RequestBody Order order)
    {
        String uri = "http://0.0.0.0:8011/api/v1/order";
        System.out.println("order" + order);
        SlotEvaluation result = restTemplate.postForObject(uri,order,SlotEvaluation.class);
        System.out.println(result);
        return new ResponseEntity<SlotEvaluation>(result,HttpStatus.OK);
    }

    @PostMapping("/slotbooked")
    public ResponseEntity<?> getSelectedSlot(@RequestBody SelectedSlot selectedSlot)
    {
        String uri = "http://0.0.0.0:8011/api/v1/bookedslot";
        System.out.println("select slot"+ selectedSlot);
        SlotEvaluation result = restTemplate.postForObject(uri,selectedSlot,SlotEvaluation.class);
        System.out.println(result);
        return new ResponseEntity<SlotEvaluation>(result,HttpStatus.OK);

    }
    @PostMapping("/saveorder")
    public ResponseEntity<?>  saveOrder(@RequestBody OrderDTO order)
    {
        System.out.println("this is order value"+order);
        String uri = "http://0.0.0.0:8010/api/v1/order";
        System.out.println("order" + order);
        SaveOrder result = restTemplate.postForObject(uri,order,SaveOrder.class);
        System.out.println(result);
        return new ResponseEntity<SaveOrder>(result,HttpStatus.OK);
    }

    @GetMapping("/routes")
    public ResponseEntity<?> getRoute(@RequestParam("slotType") String slotType,@RequestParam("date") String date)
    {
        String uri = "http://0.0.0.0:8010/api/v1/route";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri)
                .queryParam("slotType", slotType)
                .queryParam("date",date);

        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("slotType",slotType);
        uriParams.put("date",date);
        List<Vehicle> result = restTemplate.getForObject(builder.buildAndExpand(uriParams).toUri(),List.class);
        System.out.println(result);
        return new ResponseEntity<List<Vehicle>>((List<Vehicle>) result,HttpStatus.OK);
    }


    @GetMapping("getSlot/")
    public ResponseEntity<?> getSlot(@RequestParam("date") String date)
    {
        String uri = "http://0.0.0.0:8011/api/v1/getSlot";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri)
                .queryParam("date", date);


        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("date",date);
        SlotEvaluation result = restTemplate.getForObject(builder.buildAndExpand(uriParams).toUri(),SlotEvaluation.class);
        System.out.println(result);
        return new ResponseEntity<SlotEvaluation>(result,HttpStatus.OK);
    }

}

