
package com.stackroute.productservice.service;


import com.stackroute.productservice.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.repository.ProductRepository;
import com.stackroute.rabbitmq.domain.ProductDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    Product product;


    //Create a mock for UserRepository
    @Mock
    ProductRepository productRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    ProductServiceImpl productService;
    List<Product> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        product =new Product();
        product.setProductId("100");
        product.setProductName("Raymond shoe");
        product.setProductType("good");
        product.setImageURL("hkjh nkj");
        product.setMrp("2000");
        product.setPrice("1499");
        product.setDimension("14*10*5");
        product.setWeight("750gm");
        product.setSize("4,5,6,7,8,9");
        product.setGender("Women");
        product.setDescription("Raymond shoes for Women");
        product.setBrand("Raymond");
        product.setBrandId("1");
        product.setColour("Black");
        product.setProductTypeId("1");
        list = new ArrayList<>();
        list.add(product);


    }

    @Test
    public void saveProductTestSuccess() throws ProductAlreadyExistsException {

        when(productRepository.save((Product)any())).thenReturn(product);
        Product savedProduct = productService.saveProduct(product);
        Assert.assertEquals(product, savedProduct);

        //verify here verifies that userRepository save method is only called once
        verify(productRepository,times(1)).save(product);

    }
    @Test(expected = ProductAlreadyExistsException.class)
    public void saveProductTestFailure() throws ProductAlreadyExistsException {
        when(productRepository.save((Product)any())).thenReturn(null);
        Product savedProductDTO = productService.saveProduct(product);
        System.out.println("savedtrack" + savedProductDTO);
        Assert.assertEquals(product, savedProductDTO);



    }



    @Test
    public void updateProductTest() throws ProductAlreadyUpdatedException
    {
        when(productRepository.save((Product)any())).thenReturn(product);
        Product updateProduct = null;
        try {
            updateProduct = productService.saveProduct(product);
        } catch (ProductAlreadyExistsException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(product, updateProduct);
    }



    @Test
    public void getAllProducts(){

        productRepository.save(product);
        //stubbing the mock to return specific data
        when(productRepository.findAll()).thenReturn(list);
        List<Product> tracklist = productService.getAllProducts();
        Assert.assertEquals(list,tracklist);
    }




}
