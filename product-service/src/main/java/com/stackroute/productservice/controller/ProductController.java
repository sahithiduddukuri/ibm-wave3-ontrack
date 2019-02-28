package com.stackroute.productservice.controller;

import com.stackroute.productservice.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import com.stackroute.productservice.service.ProductService;
import com.stackroute.productservice.service.RabbitMqProducer;
import com.stackroute.rabbitmq.domain.ProductDTO;
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
    private ProductDTO productDTO;
    ResponseEntity responseEntity;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    RabbitMqProducer rabbitMqProducer;
    @ApiOperation(value="return saveproduct")
    @ApiResponses(value={@ApiResponse(code=100,message=" hello")})
    @PostMapping("product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) throws ProductAlreadyExistsException {


            productService.saveProduct(product);
            responseEntity=new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);
            productDTO.setProductId(product.getProductId());

                 productDTO.setProductName(productDTO.getProductName());
                   productDTO.setProductType(productDTO.getProductType());
        productDTO.setProductTypeId(productDTO.getProductTypeId());
        productDTO.setImageURL(productDTO.getMrp());
        productDTO.setMrp(productDTO.getMrp());
        productDTO.setPrice(productDTO.getPrice());
        productDTO.setDimension(productDTO.getDimension());
        productDTO.setWeight(productDTO.getWeight());
        productDTO.setSize(productDTO.getSize());
        productDTO.setGender(productDTO.getGender());
        productDTO.setDescription(productDTO.getDescription());
        productDTO.setBrand(productDTO.getBrand());
        productDTO.setBrandId(productDTO.getBrandId());
        productDTO.setColour(productDTO.getColour());



            rabbitMqProducer.produce(productDTO);
            return responseEntity;

    }
    @ApiOperation(value="return updateproduct")
    @PutMapping("product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) throws ProductAlreadyUpdatedException {


            productService.updateProduct(product);
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
        return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);

    }

}
