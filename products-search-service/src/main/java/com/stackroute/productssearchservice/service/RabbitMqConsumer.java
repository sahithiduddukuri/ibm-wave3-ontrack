package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    @RabbitListener(queues="${jsa.rabbitmq.queue1}", containerFactory="jsaFactory")
    public void recievedMessage(Product product) {

        System.out.println("Recieved Message:" +product);
//        System.out.println(user.getPassword());

    }
}
