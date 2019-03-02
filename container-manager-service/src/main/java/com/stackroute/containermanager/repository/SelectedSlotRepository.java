package com.stackroute.containermanager.repository;

import com.stackroute.containermanager.domain.SelectedSlot;
import com.stackroute.containermanager.domain.SlotEvaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface SelectedSlotRepository extends MongoRepository<SelectedSlot, LocalDate> {
}
