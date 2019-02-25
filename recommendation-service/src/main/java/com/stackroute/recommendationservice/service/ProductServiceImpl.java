package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Products;
import com.stackroute.recommendationservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    @Autowired

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getAll()
    {
        return (List<Products>) productRepository.getAllProducts();
    }

    public Products createNode(Products products) {
        Products node = productRepository.save(products);
        return node;
    }
}

