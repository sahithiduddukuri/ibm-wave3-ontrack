package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.Size;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface SizeRepository extends Neo4jRepository<Size, Integer> {

    @Query("match(n:Size) return n")
    List<Size> getAllSizes();

    @Query("create (size:Size)")
    Size createSize(Size size);
}
