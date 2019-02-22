package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<ProductRepository , Integer> {

    @Query("match(n:Product) return n")
    List<Product> getAllProducts();

    @Query("create (product:Product)")
    Product createProductNode(Product product);
}
