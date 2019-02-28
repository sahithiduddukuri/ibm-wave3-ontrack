package com.stackroute.productservice.service;

import com.stackroute.rabbitmq.domain.ProductDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private ProductDTO productDTO;
    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey1}")
    private String routingkey1;

    @Value("${jsa.rabbitmq.routingkey2}")
    private String routingkey2;



    public void produce(ProductDTO productDTO) {
           for(int i=1;i<=100;i++) {
               amqpTemplate.convertAndSend(exchange, routingkey1, productDTO);
               amqpTemplate.convertAndSend(exchange, routingkey2, productDTO);
               System.out.println("Send msg = " + productDTO);
           }
    }
}
