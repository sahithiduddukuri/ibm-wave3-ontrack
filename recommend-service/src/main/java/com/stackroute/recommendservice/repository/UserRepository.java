package com.stackroute.recommendservice.repository;

import com.stackroute.recommendservice.domain.Product;
import com.stackroute.recommendservice.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends Neo4jRepository<User,String> {

    @Query("match(n:User) return n")
    List<User> getAllUser();

    @Query("create (User:user)")
    User createUser(User user);

    @Query("MATCH (a:User)-[r:purchases]->(b:Product) where b.type='casual shoes' return a,r,b")
    Collection<User> getAllUsers();


}
