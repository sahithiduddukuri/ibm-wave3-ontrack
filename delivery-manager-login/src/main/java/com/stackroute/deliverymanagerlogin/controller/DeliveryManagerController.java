package com.stackroute.deliverymanagerlogin.controller;


import com.stackroute.deliverymanagerlogin.exception.UserIdAndPasswordMismatchException;
import com.stackroute.deliverymanagerlogin.exception.UserNameOrPasswordEmpty;
import com.stackroute.deliverymanagerlogin.exception.UserNotFoundException;
import com.stackroute.deliverymanagerlogin.model.DeliveryManager;
import com.stackroute.deliverymanagerlogin.security.SecurityTokenGenerator;
import com.stackroute.deliverymanagerlogin.services.DeliveryManagerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/")
public class DeliveryManagerController {

    private DeliveryManagerService deliveryManagerService;
    ResponseEntity responseEntity;

    @Autowired
    public DeliveryManagerController(DeliveryManagerService deliveryManagerService) {
        this.deliveryManagerService = deliveryManagerService;
    }

    @PostMapping("deliveryManager")
    public ResponseEntity login(@RequestBody DeliveryManager loginDetails) {
        try {

            String managerId = loginDetails.getManagerId();
            String password = loginDetails.getPassword();

            if (managerId == null || password == null) {
                throw new UserNameOrPasswordEmpty("Userid and Password cannot be empty");
            }

            DeliveryManager deliveryManager = deliveryManagerService.findByManagerIdAndPassword(managerId, password);

            if (deliveryManager == null) {
                throw new UserNotFoundException("User with given Id does not exists");
            }

            String fetchedPassword = deliveryManager.getPassword();
            if (!password.equals(fetchedPassword)) {
                throw new UserIdAndPasswordMismatchException("Invalid login credential, Please check username and password ");
            }

            // generating token
            SecurityTokenGenerator securityTokenGenerator = (DeliveryManager userDetails) -> {

                String jwtToken = "";
                jwtToken = Jwts.builder().setId(deliveryManager.getManagerId()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

                Map<String, String> map1 = new HashMap<>();
                map1.put("token", jwtToken);
                map1.put("message", "User successfully logged in");
                return map1;
            };

            Map<String, String> map = securityTokenGenerator.generateToken(deliveryManager);

            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (UserNameOrPasswordEmpty | UserNotFoundException | UserIdAndPasswordMismatchException exception) {

            return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("deliveryManager")
    public ResponseEntity<?> getAllManagers()
    {
        return new ResponseEntity<List<DeliveryManager>>(deliveryManagerService.getAllManagers(),HttpStatus.OK);
    }

    @ApiOperation(value="Accept delivery manager into repository")
    @PostMapping("deliveryManagers")
    public ResponseEntity<?> saveEvent(@RequestBody DeliveryManager deliveryManager) throws UserNotFoundException
    {
        try{
            deliveryManagerService.saveManager(deliveryManager);
            responseEntity = new ResponseEntity<DeliveryManager>(deliveryManager, HttpStatus.OK);
        }
        catch (UserNotFoundException ex)
        {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
        }

        return responseEntity;
    }
}
