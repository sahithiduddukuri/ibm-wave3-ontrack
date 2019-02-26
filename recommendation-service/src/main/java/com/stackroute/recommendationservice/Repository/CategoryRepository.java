package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category, String> {
    @Query("match(n:Category) return n")
    List<Category> getAllCategories();

    @Query("create (c:Category) SET c.id={categoryId},c.productType={productType}")
    Category createCategoryNode(@Param("categoryId") long categoryId, @Param("productType") String productType);
}
