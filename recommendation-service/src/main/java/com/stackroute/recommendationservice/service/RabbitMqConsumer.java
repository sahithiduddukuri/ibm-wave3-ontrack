package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Brand;
import com.stackroute.recommendationservice.Domain.Product;
import com.stackroute.recommendationservice.Domain.Products;
import com.stackroute.recommendationservice.Repository.BrandRepository;
import com.stackroute.recommendationservice.Repository.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    Brand brand = new Brand();
    Product product =new Product();
    @RabbitListener(queues="${jsa.rabbitmq.queue1}", containerFactory="jsaFactory")
    public void recievedMessage(Products products) {

        product.setProductName(products.getProductName());
        product.setProductId(products.getProductId());
        System.out.println(product.toString());
        productRepository.save(product);

        brand.setBrandName(products.getBrand());
        brandRepository.save(brand);

    }
}

