//package com.stackroute.containermanagerservice.feedcomponent;
//
//import com.stackroute.containermanagerservice.domain.Order;
//import com.stackroute.containermanagerservice.service.OrderService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//@Data
//@Primary
//public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
//{
//    @Autowired
//    Environment environment;
//    @Autowired
//    OrderService containerService;
//    Order feedContainerData=new Order();
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
//    {
//        feedContainerData.setOrderTime(environment.getProperty("container.1.orderId"));
//        feedContainerData.setProductId(Integer.parseInt(environment.getProperty("container.1.productId")));
//        feedContainerData.setProductWeight(Integer.parseInt(environment.getProperty("container.1.productWeight")));
//        feedContainerData.setProductLength(Integer.parseInt(environment.getProperty("container.1.productLength")));
//        feedContainerData.setProductWidth(Integer.parseInt(environment.getProperty("container.1.productWidth")));
//        feedContainerData.setProductBreadth(Integer.parseInt(environment.getProperty("container.1.productBreadth")));
//        //feedContainerData.isFragile(environment.getProperty("container.1.isFragile")));
//        feedContainerData.setDeliveryLocation(environment.getProperty("container.1.deliveryLocation"));
//        feedContainerData.setOrderDate(environment.getProperty("container.1.orderDate"));
//        feedContainerData.setOrderTime(environment.getProperty("container.1.orderTime"));
//
//    }
//}
