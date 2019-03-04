package com.stackroute.recommendationservice.Repository;

import com.stackroute.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Integer> {

    @Query("match(n:User) return n")
    List<User> getAllUser();

    @Query("create (u:User)")
    User createUser(User user);

}
