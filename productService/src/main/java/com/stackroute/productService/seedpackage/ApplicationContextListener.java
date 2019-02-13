package com.stackroute.productService.seedpackage;

import com.stackroute.productService.domain.Product;
import com.stackroute.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.sound.midi.Track;


@Configuration
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
    private ProductRepository productRepository;
    @Autowired

    public ApplicationContextListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Product p1= Product.builder().productName("sports wear").productPrice("&95").build();
        productRepository.save(p1);
        Product p2= Product.builder().productName("formal wear").productPrice("&45").build();
        productRepository.save(p2);

    }
}

