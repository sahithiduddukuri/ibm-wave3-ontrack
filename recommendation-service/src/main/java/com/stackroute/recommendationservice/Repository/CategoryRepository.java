package com.stackroute.recommendationservice.Repository;

import com.stackroute.domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category, String> {
    @Query("match(n:Category) return n")
    List<Category> getAllCategories();

    @Query("create (c:Category) SET c.id={productId},c.productType={productType}")
    Category createCategoryNode(@Param("productId") String productId, @Param("productType") String productType);
}
