package com.stackroute.deliverymanagerlogin.services;

import com.stackroute.deliverymanagerlogin.exception.UserIdAndPasswordMismatchException;
import com.stackroute.deliverymanagerlogin.exception.UserNotFoundException;
import com.stackroute.deliverymanagerlogin.model.DeliveryManager;
import com.stackroute.deliverymanagerlogin.repository.DeliveryManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManagerServiceImpl implements DeliveryManagerService {

    private DeliveryManagerRepository deliveryManagerRepository;

    @Autowired
    public DeliveryManagerServiceImpl(DeliveryManagerRepository deliveryManagerRepository) {
        super();
        this.deliveryManagerRepository = deliveryManagerRepository;
    }

    @Override
    public DeliveryManager saveManager(DeliveryManager deliveryManager) throws UserNotFoundException{
        if(deliveryManagerRepository.existsById(deliveryManager.getManagerId())){
            throw new UserNotFoundException("User not found");
        }
        return deliveryManagerRepository.save(deliveryManager);}

    @Override
    public List<DeliveryManager> getAllManagers(){return deliveryManagerRepository.findAll();}

    @Override
    public DeliveryManager findByManagerIdAndPassword(String managerId, String password) throws UserIdAndPasswordMismatchException {
        return deliveryManagerRepository.findByManagerIdAndPassword(managerId,password);
    }

}
