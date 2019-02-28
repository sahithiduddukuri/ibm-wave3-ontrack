package com.stackroute.productservice.service;

import com.stackroute.productservice.domain.Product;
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



    public void produce(Product product) {

//           for(int i=1;i<=100;i++) {
               amqpTemplate.convertAndSend(exchange, routingkey1, product);
               amqpTemplate.convertAndSend(exchange, routingkey2, product);
               System.out.println("Send msg = ========" + product);
//           }
    }
}
