package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.Domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Integer> {

    @Query("match(n:user) return n")
    List<User> getAllUser();

    @Query("create (User:user)")
    User createUser(User user);

}
