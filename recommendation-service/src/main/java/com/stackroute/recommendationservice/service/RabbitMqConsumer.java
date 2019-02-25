package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    @RabbitListener(queues="${jsa.rabbitmq.autoDeleteQueue1}", containerFactory="jsaFactory")
    public void recievedMessage(Product product) {

        System.out.println("Recieved Message:" +product );
//        System.out.println(user.getPassword());

    }
}

