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

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingkey1;

    ObjectMapper objectMapper=new ObjectMapper();
    public void produce(Products products) {
        try {
            amqpTemplate.convertAndSend(exchange, routingkey1,objectMapper.writeValueAsString(products));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Send msg = " + products);
    }
}
