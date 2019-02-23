package com.stackroute.productservice.service;

import com.stackroute.productservice.domain.Products;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;

import java.util.List;

public interface ProductService {
    public Products saveProduct(Products products) throws ProductAlreadyExistsException;
    public Products updateProduct(Products products) throws ProductAlreadyUpdatedException;
    public boolean deleteProduct(String id) throws ProductIdNotFoundException;
    public List<Products> getAllProducts();

}
