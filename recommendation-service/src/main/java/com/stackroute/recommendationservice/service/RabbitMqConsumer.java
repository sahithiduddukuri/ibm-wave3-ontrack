package com.stackroute.recommendationservice.service;

import com.stackroute.domain.Category;
import com.stackroute.domain.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    @Autowired
    CategoryService categoryService;

    Category category = new Category();
    @RabbitListener(queues="${jsa.rabbitmq.queue2}", containerFactory="jsaFactory")
    public void recievedMessage(Product product) {

        System.out.println("Recieved Message:" +product.getBrand());
        System.out.println("rabbitMq call");
//        System.out.println(user.getPassword());
        category.setProductType(product.getProductType());
        category.setProductTypeId(product.getProductTypeId());
       categoryService.createNode(category);

        System.out.println("recieved : " +category.toString());


    }
}
