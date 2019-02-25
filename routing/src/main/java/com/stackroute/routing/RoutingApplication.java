package com.stackroute.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoutingApplication {

	private Solution solution = new Solution(5,5,6,6);

	public static void main(String[] args) {

		SpringApplication.run(RoutingApplication.class, args);
		RoutingApplication routingApplication = new RoutingApplication();
		routingApplication.solution.getNodes();
		routingApplication.solution.containerFilling();

	}
}

