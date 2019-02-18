package com.stackroute.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoutingApplication {

	private Distance distance = new Distance();

	public static void main(String[] args) {

		SpringApplication.run(RoutingApplication.class, args);
		RoutingApplication routingApplication = new RoutingApplication();
		routingApplication.getCalculatedDistance();
	}

	public void getCalculatedDistance() {
		System.out.println("getCalculate distance call==========");
		distance.calculateDistance();
	}
}

