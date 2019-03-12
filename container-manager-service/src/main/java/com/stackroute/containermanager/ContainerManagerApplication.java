package com.stackroute.containermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ContainerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainerManagerApplication.class, args);
	}

}
