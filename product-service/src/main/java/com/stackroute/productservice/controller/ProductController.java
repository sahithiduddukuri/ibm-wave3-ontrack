package com.stackroute.productservice.controller;
import com.stackroute.productservice.domain.Products;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import com.stackroute.productservice.service.ProductService;
import com.stackroute.productservice.service.RabbitMqProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="this is controller",description = "this is product controller")
public class ProductController {
    private ProductService productService;
    ResponseEntity responseEntity;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    @Autowired
    RabbitMqProducer rabbitMqProducer;
    @ApiOperation(value="return saveproduct")
    @ApiResponses(value={@ApiResponse(code=100,message=" hello")})
    @PostMapping("products")
    public ResponseEntity<?> saveProduct(@RequestBody Products products) throws ProductAlreadyExistsException {


            productService.saveProduct(products);
            responseEntity=new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);

            rabbitMqProducer.produce(products);
            return responseEntity;

    }
    @ApiOperation(value="return updateproduct")
    @PutMapping("products")
    public ResponseEntity<?> updateProduct(@RequestBody Products products) throws ProductAlreadyUpdatedException {


            productService.updateProduct(products);
            responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);

        return responseEntity;

    }
    @ApiOperation(value="return deleteproduct")
    @DeleteMapping("product/{id}")

    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) throws ProductIdNotFoundException
    {

            productService.deleteProduct(id);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);


        return responseEntity;
    }
    @GetMapping("product")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<List<Products>>(productService.getAllProducts(),HttpStatus.OK);
    }
    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException

    {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }
}
