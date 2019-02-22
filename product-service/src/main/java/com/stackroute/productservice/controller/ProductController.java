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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) throws ProductIdNotFoundException
    {

            productService.deleteProduct(id);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);


        return responseEntity;
    }
    @GetMapping("product")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<List<Products>>(productService.getAllProducts(),HttpStatus.OK);
    }
}
