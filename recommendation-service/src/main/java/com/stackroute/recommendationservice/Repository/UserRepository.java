package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.domain.Address;
import com.stackroute.recommendationservice.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, String> {

    @Query("match(n:User) return n")
    List<User> getAllUser();

    @Query("create (u:User) SET u.name={name},u.userId={userId},u.gender={gender},u.dateofBirth={dateofBirth},u.mobileNo={mobileNo},u.password={password},u.address={address}")
    User createUserNode(@Param("name") String name, @Param("userId") String userId, @Param("gender") String gender, @Param("dateofBirth") String dateofBirth, @Param("mobileNo") String mobileNo, @Param("password") String password, @Param("address") Address address);

}
