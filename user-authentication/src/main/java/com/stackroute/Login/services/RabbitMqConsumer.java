package com.stackroute.Login.services;

import com.stackroute.Login.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    @RabbitListener(queues="${jsa.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(User user) {

        System.out.println("Recieved Message: userId:" + user.getUserId() + ", password:" + user.getPassword());
//        System.out.println(user.getPassword());

    }
}
