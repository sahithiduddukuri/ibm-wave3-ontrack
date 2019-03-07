package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.Message;
import com.stackroute.registrationservice.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private Message msg;
    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingkey;

    public void produce(User user){
        msg = new Message(user.getUserId(), user.getPassword());
        amqpTemplate.convertAndSend(exchange, routingkey, msg);
        System.out.println("Send msg = " + msg);
    }
}
