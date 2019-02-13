package com.stackroute.deliverymanager.controller;


import com.stackroute.deliverymanager.exception.UserNameOrPasswordEmpty;
import com.stackroute.deliverymanager.exception.UserNotFoundException;
import com.stackroute.deliverymanager.model.DeliveryManager;
import com.stackroute.deliverymanager.services.DeliveryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class DeliveryManagerController {

    private DeliveryManagerService deliveryManagerService;
    ResponseEntity responseEntity;
    @Autowired
    public DeliveryManagerController(DeliveryManagerService deliveryManagerService) {
        this.deliveryManagerService = deliveryManagerService;
    }

    @PostMapping("deliveryManager")
    public ResponseEntity<?> saveManagers(@RequestBody DeliveryManager deliveryManager) throws UserNameOrPasswordEmpty {

        try {
            if (deliveryManager.getManagerName() == null || deliveryManager.getPassword() == null) {
//            logger.warn("Please fill in username and password");
                throw new UserNameOrPasswordEmpty("Please fill in manager name and password");
            } else {
                try {
                    return new ResponseEntity<DeliveryManager>(deliveryManagerService.saveManagers(deliveryManager), HttpStatus.CREATED);
                } catch (UserNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (UserNameOrPasswordEmpty e) {
            return new ResponseEntity<String>("manager name or password is empty", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("deliveryManager")
    public ResponseEntity<?> getAllManagers()
    {
        return new ResponseEntity<List<DeliveryManager>>(deliveryManagerService.getAllManagers(),HttpStatus.OK);
    }
}
