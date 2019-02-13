package com.stackroute.productService.service;

import com.stackroute.productService.domain.Product;
import com.stackroute.productService.exceptions.ProductAlreadyExistsException;
import com.stackroute.productService.exceptions.ProductAlreadyUpdatedExcetion;
import com.stackroute.productService.exceptions.ProductIdNotFoundException;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product) throws ProductAlreadyExistsException;
    public Product updateProduct(Product product) throws ProductAlreadyUpdatedExcetion;
    public List<Product> getAllProducts();
    public List<Product> searchProduct(String name);

}
