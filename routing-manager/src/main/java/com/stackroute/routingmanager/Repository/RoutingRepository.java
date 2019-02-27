package com.stackroute.routingmanager.Repository;

import com.stackroute.routingmanager.Domain.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutingRepository extends MongoRepository<Node,String> {
}
