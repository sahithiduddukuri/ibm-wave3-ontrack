package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Product;
import com.stackroute.recommendationservice.Domain.Products;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    Product product;
    @RabbitListener(queues="${jsa.rabbitmq.autoDeleteQueue1}", containerFactory="jsaFactory")
    public void recievedMessage(Products products) {

        System.out.println("Recieved Message:" +products );
        System.out.println(product.getProductName());

    }
}

