package com.stackroute.containermanagerservice.controller;

import com.stackroute.containermanagerservice.domain.Container;
import com.stackroute.containermanagerservice.exception.ContainerAlreadyFull;
import com.stackroute.containermanagerservice.exception.ContainerNotFound;
import com.stackroute.containermanagerservice.service.ContainerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/containerservice/")
@Api(value = "A web-application that helps us to optimize container manager\n"+
             "using this app, we should be able to manage the orders")
public class ContainerController
{
    private ResponseEntity responseEntity;
    private ContainerService containerService;

    public ContainerController(final ContainerService containerService)
    {
        this.containerService = containerService;
    }

    @ApiOperation(value = "saves container details")
    @PostMapping("container")
    public ResponseEntity<?> saveContainer(@RequestBody Container container) throws ContainerAlreadyFull
    {
        try
        {
            //containerService.saveContainer(container);
            responseEntity=new ResponseEntity<>(containerService.saveContainer(container), HttpStatus.CREATED);
        }
        catch (ContainerAlreadyFull c1)
        {
            throw new ContainerAlreadyFull();
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "deletes selected containers")
    @DeleteMapping("container/{orderId}")
    public ResponseEntity<?> deleteContainer(@PathVariable("orderId") int orderId) throws ContainerNotFound
    {
        try
        {
            //containerService.deleteContainer(orderId);
            responseEntity = new ResponseEntity<>(containerService.deleteContainer(orderId), HttpStatus.OK);
        }
        catch (ContainerNotFound e)
        {

            throw new ContainerNotFound();
        }
        catch (Exception exception){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "updates selected container")
    @PutMapping("container/{orderId}")
    public ResponseEntity<?> updateContainer(@RequestBody Container container , @PathVariable ("orderId") int orderId) throws ContainerNotFound
    {
        try
        {
//            Container updatedContainer = containerService.updateContainer(container.getOrderId(),container.getProductId(),container.getProductWeight(),container.getProductLength(),
//                    container.getProductWidth(),container.getProductBreadth(),container.isFragile(),container.getDeliveryLocation(),container.getOrderDate(),
//                    container.getOrderTime(),container.getConatinerId(),container.getDate(),container.getSlotNumber());
            responseEntity = new ResponseEntity<>(containerService.updateContainer(container.getOrderId(),container.getProductId(),container.getProductWeight(),container.getProductLength(),
                    container.getProductWidth(),container.getProductBreadth(),container.isFragile(),container.getDeliveryLocation(),container.getOrderDate(),
                    container.getOrderTime(),container.getConatinerId(),container.getDate(),container.getSlotNumber()), HttpStatus.OK);
        } catch (ContainerNotFound e) {

            throw new ContainerNotFound();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity("Error !! Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "retrieves all container details")
    @GetMapping("container")
    public ResponseEntity<?> getAllContainer(){


        try{

            responseEntity = new ResponseEntity(containerService.getAllContainers() , HttpStatus.OK);

        }catch (Exception e){
            //responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }
    @ApiOperation(value = "retrives the available slots")
    @GetMapping("container/{date}")
    public ResponseEntity<?> getDateTime(@RequestBody Container container, @PathVariable("date") String date)
    {
        try
        {
            responseEntity=new ResponseEntity(containerService,HttpStatus.OK);
        }
        catch (Exception ex)
        {

        }
        return responseEntity;
    }


}
