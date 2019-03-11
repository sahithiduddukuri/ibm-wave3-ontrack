package com.stackroute.deliverymanagerlogin.feedComponent;

import com.stackroute.deliverymanagerlogin.model.DeliveryManager;
import com.stackroute.deliverymanagerlogin.repository.DeliveryManagerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private DeliveryManagerRepository deliveryManagerRepository;

    @Autowired
    public SeedDataApplicationListener(DeliveryManagerRepository deliveryManagerRepository){this.deliveryManagerRepository = deliveryManagerRepository;}
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

     deliveryManagerRepository.save(new DeliveryManager("anagha","ranganath"));
        deliveryManagerRepository.save(new DeliveryManager("krutika","ranganath"));
    }
}
