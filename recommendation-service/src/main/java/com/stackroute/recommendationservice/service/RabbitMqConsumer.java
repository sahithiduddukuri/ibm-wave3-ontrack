package com.stackroute.recommendationservice.service;

import com.stackroute.rabbitmq.domain.Category;
import com.stackroute.rabbitmq.domain.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;
    Product product;

    //Product product1 = new Product();

    Category category = new Category();
    @RabbitListener(queues="${jsa.rabbitmq.queue2}", containerFactory="jsaFactory")
    public void recievedMessage(Product product) {

        //System.out.println("Recieved Message:" +product.getProductId());
        System.out.println("rabbitMq call");
        System.out.println("recieved product: "+product.toString());
//        System.out.println(user.getPassword());
        category.setProductType(product.getProductType());
        category.setProductTypeId(product.getProductTypeId());
        categoryService.createNode(category);

        System.out.println("recieved : " +category.toString());
        //Product product1 = new Product();
           this.product=product;

//        product1.setBrand(product.getBrand());
//        product1.setBrandId(product.getBrandId());
//        product1.setColour(product.getColour());
//        product1.setDescription(product.getDescription());
//        product1.setDimension(product.getDimension());
//        product1.setGender(product.getGender());
//        product1.setImageURL(product.getImageURL());
//        product1.setMrp(product.getMrp());
//        product1.setPrice(product.getPrice());
//        product1.setProductId(product.getProductId());
//        product1.setProductName(product.getProductName());
//        product1.setProductType(product.getProductType());
//        product1.setProductTypeId(product.getProductTypeId());
        System.out.println("***************************");
        productService.createNode(this.product);

    }
}
