package com.stackroute.routingmanager.Repository;

import com.stackroute.routingmanager.Domain.SaveOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RoutingRepository extends MongoRepository<SaveOrder, String> {

//    public Order save(Order order);
}
