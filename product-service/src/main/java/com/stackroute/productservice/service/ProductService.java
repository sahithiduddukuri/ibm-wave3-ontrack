package com.stackroute.productservice.service;

import com.stackroute.productservice.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;

import java.util.List;

public interface ProductService {
<<<<<<< HEAD
    public Product saveProduct(Product products) throws ProductAlreadyExistsException;
    public Product updateProduct(Product products) throws ProductAlreadyUpdatedException;
    public boolean deleteProduct(int id) throws ProductIdNotFoundException;
    public List<Product> getAllProducts();
=======
    public Products saveProduct(Products products) throws ProductAlreadyExistsException;
    public Products updateProduct(Products products) throws ProductAlreadyUpdatedException;
    public boolean deleteProduct(String id) throws ProductIdNotFoundException;
    public List<Products> getAllProducts();
>>>>>>> 1fbdd5c34115e63bd147ca6077b7dbb1191f79a7

}
