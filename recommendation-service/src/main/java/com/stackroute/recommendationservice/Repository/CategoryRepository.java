package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category, Long> {
    @Query("match(n:Category) return n")
    List<Category> getAllCategories();

    @Query("create (c:Category) SET c.id={id},c.productType={productType}")
    Category createCategoryNode(@Param("id") long id, @Param("productType") String productType);
}