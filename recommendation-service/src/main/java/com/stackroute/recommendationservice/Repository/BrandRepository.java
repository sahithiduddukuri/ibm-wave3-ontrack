package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Brand;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends Neo4jRepository<Brand, Long> {

    @Query("match(n:Brand) return n")
    List<Brand> getAll();

    @Query("create (b:Brand) SET b.brandId={brandId},b.brandName={brandName}")
    Brand createBrand(@Param("brandId") long brandId, @Param("brandName") String brandName);
}

