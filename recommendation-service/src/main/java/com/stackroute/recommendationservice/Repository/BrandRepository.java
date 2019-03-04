package com.stackroute.recommendationservice.Repository;

import com.stackroute.domain.Brand;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends Neo4jRepository<Brand, String> {

    @Query("match(n:Brand) return n")
    List<Brand> getAll();

    @Query("create (b:Brand) SET b.brandId={brandId},b.brand={brand}")
    Brand createBrand(@Param("brandId") String brandId, @Param("brand") String brand);
}

