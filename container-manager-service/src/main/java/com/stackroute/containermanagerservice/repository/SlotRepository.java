package com.stackroute.containermanagerservice.repository;

import com.stackroute.containermanagerservice.domain.SlotCheck;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlotRepository extends MongoRepository<SlotCheck, String>
{

}
