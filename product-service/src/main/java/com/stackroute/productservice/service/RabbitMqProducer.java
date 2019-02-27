package com.stackroute.productservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.productservice.domain.Products;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private Products products;
    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey1}")
    private String routingkey1;

    @Value("${jsa.rabbitmq.routingkey2}")
    private String routingkey2;



    public void produce(Products products) {
           for(int i=1;i<=100;i++) {
               amqpTemplate.convertAndSend(exchange, routingkey1, products);
               amqpTemplate.convertAndSend(exchange, routingkey2, products);


               System.out.println("Send msg = " + products);
           }
    }
}
