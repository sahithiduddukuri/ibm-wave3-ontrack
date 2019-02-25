package com.stackroute.recommendationservice.service;
import com.stackroute.recommendationservice.Domain.Products;
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
    Products products;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;
    List<Products> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        products = new Products();
        products.setProductId("1");
        products.setProductName("Shoe");
        list = new ArrayList<> ();
        list.add(products);
    }

    @Test
    public void saveProductTest()
    {
        when(productRepository.save((Products) any())).thenReturn(products);
        Products savedProduct = productService.createNode(products);
        Assert.assertEquals(products,savedProduct);
    }

//    @Test
//    public void getProductTest() {
//        productRepository.save(product);
//        //when(productRepository.findAll()).thenReturn(list);
//        List<Product> productList = productService.getAll();
//        System.out.println(productList);
//        Assert.assertNotEquals(list, productList);
//    }
}
