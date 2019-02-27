package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.*;
import com.stackroute.recommendationservice.Repository.BrandRepository;
import com.stackroute.recommendationservice.Repository.CategoryRepository;
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

    @Autowired
    CategoryRepository categoryRepository;

    Category category = new Category();

    Brand brands = new Brand();

    Product product =new Product();

    @RabbitListener(queues="${jsa.rabbitmq.queue1}", containerFactory="jsaFactory")
    public void recievedMessage(Products products) {

        product.setProductName(products.getProductName());
        product.setProductId(products.getProductId());

      //  System.out.println(product.toString());
        productRepository.save(product);
        System.out.println(product);

        product.setBrandId(products.getBrandId());
        product.setBrand(products.getBrand());
        product.setProductType(products.getProductType());
        product.setProductTypeId(products.getProductTypeId());
        product.setColour(products.getColour());
        product.setDescription(products.getDescription());
        product.setGender(products.getGender());
        product.setDimension(products.getDimension());
        product.setImageURL(products.getImageURL());
        product.setMrp(products.getMrp());
        product.setPrice(products.getPrice());
        product.setSize(products.getSize());
        product.setWeight(products.getWeight());
        productRepository.save(product);
        System.out.println(product.toString());

        brands.setBrandId(products.getBrandId());
        brands.setBrand(products.getBrand());
        brandRepository.save(brands);
        System.out.println(brands.toString());

        category.setProductTypeId(products.getProductTypeId());
        category.setProductType(products.getProductType());
        categoryRepository.save(category);
        System.out.println(category.toString());




    }
}

