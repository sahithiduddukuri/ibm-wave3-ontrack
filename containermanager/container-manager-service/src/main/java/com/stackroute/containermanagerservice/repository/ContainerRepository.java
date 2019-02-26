package com.stackroute.containermanagerservice.repository;

import com.stackroute.containermanagerservice.domain.Container;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContainerRepository extends MongoRepository<Container, Integer>
{
    public Container UpdatedContainer(String date);
}
