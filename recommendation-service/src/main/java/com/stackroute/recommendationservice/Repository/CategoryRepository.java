package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category, Integer> {
    @Query("match(n:Category) return n")
    List<Category> getAllCategories();

    @Query("create (category:Category)")
    Category createCategoryNode(Category category);
}
