package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Brand;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface BrandRepository extends Neo4jRepository<Brand, Integer> {

    @Query("match(n:Brand) return n")
    List<Brand> getAll();

    @Query("create (brand:Brand)")
    Brand createBrand(Brand brand);
}

