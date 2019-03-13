package com.stackroute.routingmanager;

import com.stackroute.routingmanager.Domain.Location;
import com.stackroute.routingmanager.Service.Latitudelongitude;
import com.stackroute.routingmanager.Service.OptimizedSolutionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class RoutingManagerApplication {
//
//	public static void CallMethod(){
//		OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
//		optimizedSolution.optimizedCost();
//	}

	/*public static void callMethod(){
		System.out.println("Inside call method");
		List<Location> locationList = new ArrayList<>();
		Location location1 = new Location("Bangalore, Karnataka, India");
		Location location2 = new Location("Pune, Maharashtra, India");
//		Location location3 = new Location("Punjab");
		locationList.add(location1);
		locationList.add(location2);
//		locationList.add(location3);
		System.out.println("locationList===================" + locationList);

		Latitudelongitude latitudelongitude = new Latitudelongitude();
		latitudelongitude.getDistanceMatrix(locationList);
		System.out.println("locationList" + locationList);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(RoutingManagerApplication.class, args);
//		callMethod();
	}

	/*private static void callMethod() {
		OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
		optimizedSolution.optimizedCost();
	}*/

}
