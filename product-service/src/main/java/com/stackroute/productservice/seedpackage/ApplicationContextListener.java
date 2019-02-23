package com.stackroute.productservice.seedpackage;

import com.stackroute.productservice.domain.Products;
import com.stackroute.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
    private ProductRepository productRepository;
    @Autowired

    public ApplicationContextListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Products p1= Products.builder().productId("11100").productName("Red Tape")
                .productType("Sports Shoes")
                .imageURL("https://assets.myntassets.com/h_Red-Tape-Men-Off-White-Walking-Shoes-7341530609306715-1.jpg")
                .mrp("2000").price("1499").dimension("14*10*5").weight("750gm").size("6,7,8").gender("Male").description("White flexible running shoes for men,easy to wear and comfort for long running")
                .brand("Red Tape").colour("White").build();
        productRepository.save(p1);
        Products p2= Products.builder().productId("22200").productName("Raymond Slip on for Men")
                .productType("formal shoes")
                .imageURL("https://rukminim1.flixcart.com/image/832/832/jcjejrk0/shoe/f/x/x/rxss00058-b6-42-raymond-blue-original-imaffnhrcbmqsfty.jpeg?q=70")
                .mrp("7499").price("4894").dimension("14*10*5").weight("780gm").size("6,7,,8,9,10,11").gender("Men").description("Raymond Slip on shoe for Men")
                .brand("Raymond Slip op").colour("Blue").build();
        productRepository.save(p2);
    }
}
