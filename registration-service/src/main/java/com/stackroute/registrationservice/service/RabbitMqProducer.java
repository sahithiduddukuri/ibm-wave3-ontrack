package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.Msg;
import com.stackroute.registrationservice.domain.Registration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private Msg msg;
    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingkey;

    public void produce(Registration registration){
        msg = new Msg(registration.getUserId(),registration.getPassword());
        amqpTemplate.convertAndSend(exchange, routingkey, msg);
        System.out.println("Send msg = " + msg);
    }
}
