package com.stackroute.containermanagerservice.repository;

import com.stackroute.containermanagerservice.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer>
{
    //public Order UpdatedContainer(String date);
}
