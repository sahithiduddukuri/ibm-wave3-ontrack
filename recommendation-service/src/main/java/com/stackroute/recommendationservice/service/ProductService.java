package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Products;

import java.util.List;

public interface ProductService {
    public List<Products> getAll();
    public Products createNode(Products product);
}