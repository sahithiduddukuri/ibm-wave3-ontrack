package com.stackroute.deliverymanagerlogin.services;

import com.stackroute.deliverymanagerlogin.exception.UserIdAndPasswordMismatchException;
import com.stackroute.deliverymanagerlogin.exception.UserNotFoundException;
import com.stackroute.deliverymanagerlogin.model.DeliveryManager;

import java.util.List;

public interface DeliveryManagerService {
    public DeliveryManager saveManager(DeliveryManager deliveryManager) throws UserNotFoundException;
    public List<DeliveryManager> getAllManagers();
    public DeliveryManager findByManagerIdAndPassword(String managerId, String password) throws UserIdAndPasswordMismatchException;
}
