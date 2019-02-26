package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Products;
import com.stackroute.productssearchservice.exception.ProductAlreadyExistsException;
import com.stackroute.productssearchservice.exception.ProductDoesNotExistsException;

import java.util.List;

/*
 * This "ProductService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (ProductServiceImpl).
 */


public interface ProductService {
    Products saveProduct(Products product) throws ProductAlreadyExistsException;
    List<Products> getAllProductByStartswith(String productName) throws ProductDoesNotExistsException;
}
