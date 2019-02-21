package com.stackroute.productservice.service;

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

    public void produce(Products products){
        products = new Products();
        amqpTemplate.convertAndSend(exchange, routingkey1, products);
        System.out.println("Send msg = " + products);
    }
}
