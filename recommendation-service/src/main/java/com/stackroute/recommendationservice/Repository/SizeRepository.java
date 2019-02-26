package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Size;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SizeRepository extends Neo4jRepository<Size, Long> {

    @Query("match(n:Size) return n")
    List<Size> getAllSizes();

    @Query("create (s:Size) SET s.sizeId={sizeId},s.sizes={sizes}")
    Size createSize(@Param("sizeId") long sizeId, @Param("sizes") String sizes);
}
