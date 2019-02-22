package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Product;
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

    public List<Product> getAll()
    {
        return (List<Product>) productRepository.getAllProducts();
    }

    public Product createNode(Product product) {
        Product node = productRepository.createProductNode(product);
        return node;
    }
}

