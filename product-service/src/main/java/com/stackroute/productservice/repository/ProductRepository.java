package com.stackroute.productservice.repository;

import com.stackroute.productservice.domain.Products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Products, String> {
}
