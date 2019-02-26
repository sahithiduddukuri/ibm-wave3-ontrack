package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.*;
import com.stackroute.recommendationservice.Repository.BrandRepository;
import com.stackroute.recommendationservice.Repository.CategoryRepository;
import com.stackroute.recommendationservice.Repository.ProductRepository;
import com.stackroute.recommendationservice.Repository.SizeRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SizeRepository sizeRepository;

    Brand brand = new Brand();
    Product product =new Product();
    Category category = new Category();
    Size size = new Size();
    @RabbitListener(queues="${jsa.rabbitmq.queue1}", containerFactory="jsaFactory")
    public void recievedMessage(Products products) {

        product.setProductName(products.getProductName());
        product.setProductId(products.getProductId());
        //System.out.println(product.toString());
        productRepository.save(product);
        System.out.println(product.toString());

        brand.setBrandName(products.getBrand());
        brandRepository.save(brand);
        System.out.println(brand.toString());

        category.setProductType(category.getProductType());
        categoryRepository.save(category);
        System.out.println(category.toString());

        size.setSizes(products.getSize());
        sizeRepository.save(size);
        System.out.println(size.toString());


    }
}

