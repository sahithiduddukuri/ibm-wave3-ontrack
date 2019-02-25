package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Products;
import com.stackroute.productssearchservice.exception.ProductAlreadyExistsException;
import com.stackroute.productssearchservice.exception.ProductDoesNotExistsException;
import com.stackroute.productssearchservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Products saveProduct(Products products) throws ProductAlreadyExistsException {
        return productRepository.save(products);
    }

    @Override
    public List<Products> getAllProductByStartswith(String productName) throws ProductDoesNotExistsException {
       List<Products> products=productRepository.searchByProductAlphabet(productName);
       if(products==null)
           throw new ProductDoesNotExistsException("No ProductFound");
       else
        return products;
    }
}
