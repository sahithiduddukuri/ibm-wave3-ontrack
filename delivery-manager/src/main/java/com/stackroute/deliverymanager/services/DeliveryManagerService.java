package com.stackroute.deliverymanager.services;

import com.stackroute.deliverymanager.exception.UserIdAndPasswordMismatchException;
import com.stackroute.deliverymanager.exception.UserNotFoundException;
import com.stackroute.deliverymanager.model.DeliveryManager;

import java.util.List;

public interface DeliveryManagerService {
    public DeliveryManager saveManager(DeliveryManager deliveryManager) throws UserNotFoundException;
    public List<DeliveryManager> getAllManagers();
    public DeliveryManager findByManagerIdAndPassword(String managerId, String password) throws UserIdAndPasswordMismatchException;
}
