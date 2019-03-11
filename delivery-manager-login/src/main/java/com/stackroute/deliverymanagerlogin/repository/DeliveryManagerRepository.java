package com.stackroute.deliverymanagerlogin.repository;

import com.stackroute.deliverymanagerlogin.model.DeliveryManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryManagerRepository extends JpaRepository<DeliveryManager, String> {

    public DeliveryManager findByManagerIdAndPassword(String managerId, String password);
}
