package com.stackroute.containermanager.repository;

import com.stackroute.containermanager.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContainerRepository extends MongoRepository<Order,String > {
}
