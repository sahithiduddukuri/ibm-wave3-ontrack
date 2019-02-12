package com.stackroute.deliverymanager.services;

import com.stackroute.deliverymanager.exception.UserNotFoundException;
import com.stackroute.deliverymanager.model.DeliveryManager;
import com.stackroute.deliverymanager.repository.DeliveryManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManagerServiceImpl implements DeliveryManagerService {

    private DeliveryManagerRepository deliveryManagerRepository;

    @Autowired
    public DeliveryManagerServiceImpl(DeliveryManagerRepository deliveryManagerRepository) {
        this.deliveryManagerRepository = deliveryManagerRepository;
    }

    @Override
    public DeliveryManager saveManagers(DeliveryManager deliveryManager) throws UserNotFoundException{
        if(deliveryManagerRepository.existsById(deliveryManager.getManagerName())){
           throw new UserNotFoundException("DeliveryManager not found.");

        }
        else {
            DeliveryManager savedDeliveryManager = deliveryManagerRepository.save(deliveryManager);

            return savedDeliveryManager;
        }
    }

    @Override
    public List<DeliveryManager> getAllManagers() {
        return deliveryManagerRepository.findAll();
    }
}
