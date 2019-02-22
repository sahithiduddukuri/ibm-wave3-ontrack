package com.stackroute.recommendationservice.service;
import com.stackroute.recommendationservice.Domain.Product;
import com.stackroute.recommendationservice.Repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

public class ProductServiceTest {
    Product product;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;
    List<Product> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        product.setProductId(1);
        product.setProductName("Shoe");
        list = new ArrayList<>();
        list.add(product);
    }

//    @Test
//    public void saveProductTest()
//    {
//        when(productRepository.save((product)any())).thenReturn(product);
//        Product savedProduct = productService.createNode(product);
//        Assert.assertEquals(product,savedProduct);
//    }
//
//    @Test
//    public void getProductTest() {
//        productRepository.save(product);
//        when(productRepository.findAll()).thenReturn(list);
//        List<Product> productList = productService.getAll();
//        Assert.assertEquals(list, productList);
//    }
}
