package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMqConsumer {
    @RabbitListener(queues="${jsa.rabbitmq.queue2}", containerFactory="jsaFactory")
    public void recievedMessage(Product product) {

        System.out.println("Recieved Message:" +product);
//        System.out.println(user.getPassword());

    }
}
