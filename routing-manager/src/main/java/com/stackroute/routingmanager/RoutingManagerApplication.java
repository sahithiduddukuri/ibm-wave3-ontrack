package com.stackroute.routingmanager;

import com.stackroute.routingmanager.Service.OptimizedSolutionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoutingManagerApplication {
//
//	public static void CallMethod(){
//		OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
//		optimizedSolution.optimizedCost();
//	}

	public static void main(String[] args) {
		SpringApplication.run(RoutingManagerApplication.class, args);
		//callMethod();
	}

	/*private static void callMethod() {
		OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
		optimizedSolution.optimizedCost();
	}*/

}
