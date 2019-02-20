package com.stackroute.recommendationservice.repository;

import com.stackroute.recommendationservice.domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<Product,String> {

    @Query("match(n:Product) return n")
    List<Product> getAllProducts();

    @Query("match(n:Product) return n")
    Product updateProduct(Product product);


    @Query("create (Product:product)")
    Product save(Product product);

}
