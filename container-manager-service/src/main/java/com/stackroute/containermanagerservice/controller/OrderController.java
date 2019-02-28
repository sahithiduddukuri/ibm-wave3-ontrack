package com.stackroute.containermanagerservice.controller;

import com.stackroute.containermanagerservice.domain.Order;
import com.stackroute.containermanagerservice.exception.OrderAlreadyExists;
import com.stackroute.containermanagerservice.exception.InvalidOrder;
import com.stackroute.containermanagerservice.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/orderservice/")
@Api(value = "A web-application that helps us to optimize container manager\n"+
             "using this app, we should be able to manage the orders")
public class OrderController
{
    private ResponseEntity responseEntity;
    private OrderService orderService;

    public OrderController(final OrderService orderService)
    {
        this.orderService = orderService;
    }

    @ApiOperation(value = "saves order details")
    @PostMapping("order")
    public ResponseEntity<?> saveContainer(@RequestBody Order order) throws OrderAlreadyExists
    {
        try
        {
            //orderService.saveContainer(order);
            responseEntity=new ResponseEntity<>(orderService.saveContainer(order), HttpStatus.CREATED);
        }
        catch (OrderAlreadyExists c1)
        {
            throw new OrderAlreadyExists();
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "deletes selected containers")
    @DeleteMapping("container/{orderId}")
    public ResponseEntity<?> deleteContainer(@PathVariable("orderId") int orderId) throws InvalidOrder
    {
        try
        {
            //orderService.deleteContainer(orderId);
            responseEntity = new ResponseEntity<>(orderService.deleteContainer(orderId), HttpStatus.OK);
        }
        catch (InvalidOrder e)
        {

            throw new InvalidOrder();
        }
        catch (Exception exception){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "updates selected order")
    @PutMapping("order/{orderId}")
    public ResponseEntity<?> updateContainer(@RequestBody Order order, @PathVariable ("orderId") int orderId) throws InvalidOrder
    {
        try
        {
//            Order updatedContainer = orderService.updateContainer(order.getOrderId(),order.getProductId(),order.getProductWeight(),order.getProductLength(),
//                    order.getProductWidth(),order.getProductBreadth(),order.isFragile(),order.getDeliveryLocation(),order.getOrderDate(),
//                    order.getOrderTime(),order.getConatinerId(),order.getDate(),order.getSlotNumber());
            responseEntity = new ResponseEntity<>(orderService.updateContainer(order.getOrderId(), order.getProductId(), order.getProductWeight(), order.getProductLength(),
                    order.getProductWidth(), order.getProductBreadth(), order.isFragile(), order.getDeliveryLocation(), order.getOrderDate(),
                    order.getOrderTime()), HttpStatus.OK);
        } catch (InvalidOrder e) {

            throw new InvalidOrder();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity("Error !! Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "retrieves all container details")
    @GetMapping("order")
    public ResponseEntity<?> getAllContainer(){


        try{

            responseEntity = new ResponseEntity(orderService.getAllContainers() , HttpStatus.OK);

        }catch (Exception e){
            //responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }
    @ApiOperation(value = "retrives the available slots")
    @GetMapping("order/{date}")
    public ResponseEntity<?> getDateTime(@RequestBody Order order, @PathVariable("date") String date)
    {
        try
        {
            responseEntity=new ResponseEntity(orderService,HttpStatus.OK);
        }
        catch (Exception ex)
        {

        }
        return responseEntity;
    }


}
