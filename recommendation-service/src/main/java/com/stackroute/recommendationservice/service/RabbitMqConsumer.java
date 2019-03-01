//package com.stackroute.recommendationservice.service;
//
//import com.stackroute.recommendationservice.Domain.Product;
//import com.stackroute.recommendationservice.Domain.Products;
//import com.stackroute.recommendationservice.Repository.ProductRepository;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RabbitMqConsumer {
//
//    @Autowired
//    ProductRepository productRepository;
//
//    Product product;
//    @RabbitListener(queues="${jsa.rabbitmq.}", containerFactory="jsaFactory")
//    public void recievedMessage(Products products) {
//
//        System.out.println("Recieved Message:" +products );
//        //System.out.println(product.getProductName());
//        product.setProductName(products.getProductName());
//        product.setProductId(products.getProductId());
//        product.setBrandId(products.getBrandId());
//        product.setBrand(products.getBrand());
//        product.setProductType(products.getProductType());
//        products.setProductTypeId(products.getProductTypeId());
//        products.setColour(products.getColour());
//        products.setDescription(products.getDescription());
//        products.setGender(products.getGender());
//        products.setDimension(products.getDimension());
//        products.setImageURL(products.getImageURL());
//        products.setMrp(products.getMrp());
//        products.setPrice(products.getPrice());
//        products.setSize(products.getSize());
//        products.setWeight(products.getWeight());
//        System.out.println("-------------------------------------------");
//        productRepository.save(product);
//        //System.out.println(products.toString());
//
//    }
//}
//
