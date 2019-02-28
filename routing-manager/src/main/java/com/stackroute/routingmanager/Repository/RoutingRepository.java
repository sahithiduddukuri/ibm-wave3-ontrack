package com.stackroute.routingmanager.Repository;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutingRepository extends MongoRepository<Order,String> {

//    public Order save(Order order);
}
