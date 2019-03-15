package com.stackroute.recommendationservice.Repository;

import com.stackroute.rabbitmq.domain.Brand;
import com.stackroute.recommendationservice.domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


public interface BrandRepository extends Neo4jRepository<Brand, String> {

    @Query("MATCH (a:Product), (b:Brand) where b.brand = a.brand MERGE (a)-[:IS_OF_BRAND]->(b) return a,b")
    Product getAllBrands();

    @Query("Create (b:Brand) SET b.brandId={brandId},b.brand={brand}")
    Brand createBrand(@Param("brandId") String brandId, @Param("brand") String brand);
}
