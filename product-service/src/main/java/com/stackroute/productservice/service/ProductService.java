package com.stackroute.productservice.service;

import com.stackroute.productservice.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product products) throws ProductAlreadyExistsException;
    public Product updateProduct(Product products) throws ProductAlreadyUpdatedException;
    public boolean deleteProduct(int id) throws ProductIdNotFoundException;
    public List<Product> getAllProducts();

}
