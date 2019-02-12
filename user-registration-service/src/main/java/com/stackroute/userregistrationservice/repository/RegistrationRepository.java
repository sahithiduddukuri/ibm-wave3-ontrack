package com.stackroute.userregistrationservice.repository;

import com.stackroute.userregistrationservice.domain.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration,String>
{
    
}
