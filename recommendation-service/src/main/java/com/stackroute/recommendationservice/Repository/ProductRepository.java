package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Products;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<ProductRepository , String> {

    @Query("match(n:Product) return n")
    List<Products> getAllProducts();

    @Query("create (product:Product)")
    Products save(Products products);
}
