package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Products;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

    @RabbitListener(queues="${jsa.rabbitmq.queue2}", containerFactory="jsaFactory")
    public void recievedMessage(Products products) {

        System.out.println("Recieved Message:" +products);
//        System.out.println(user.getPassword());

    }
}
