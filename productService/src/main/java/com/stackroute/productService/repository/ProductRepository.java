package com.stackroute.productService.repository;


import com.stackroute.productService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


    List<Product> findByproductName(String productName);
}
