package com.stackroute.containermanager.repository;

import com.stackroute.containermanager.domain.Order;
import com.stackroute.containermanager.domain.SlotEvaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;

public interface SlotRepository extends MongoRepository<SlotEvaluation, String>
{
    //public SlotEvaluation findByDate(Date date);

}
