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
    Brand brand;
    Product product =new Product();
    Products products;
    @RabbitListener(queues="${jsa.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Products products) {

        product.setName(products.getProductName());
        System.out.println(product.toString());
        productRepository.save(product);

        brand.setName(products.getBrand());
        brandRepository.createBrand(brand);

    }
}

