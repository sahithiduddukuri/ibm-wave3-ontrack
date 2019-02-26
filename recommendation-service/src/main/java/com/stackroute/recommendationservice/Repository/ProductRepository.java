package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<Product , String> {

    @Query("match(n:Product) return n")
    List<Product> getAllProducts();

//    @Query("create (product:Product)")
//    Product save(Product product);

    @Query("create (p:Products) SET p.productId={productId},p.productName={productName}")
    Product create(@Param("productId") String productId, @Param("productName") String productName);
}
