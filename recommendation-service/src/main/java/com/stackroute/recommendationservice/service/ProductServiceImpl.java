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
        return (List<Product>) productRepository.findAll();
    }

    public Product createNode(Product product) {
        String productId = product.getProductId();
        String productName=product.getProductName();
        Product node = productRepository.create(productId,productName);
        return node;
    }


    }

