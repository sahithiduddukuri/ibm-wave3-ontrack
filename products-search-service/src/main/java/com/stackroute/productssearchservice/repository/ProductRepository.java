package com.stackroute.productssearchservice.repository;

import com.stackroute.productssearchservice.domain.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Products,Integer> {
    @Query("{productName:{ $regex: '?0', $options: 'i'}}")
    List<Products> searchByProductAlphabet(String productName);
}
