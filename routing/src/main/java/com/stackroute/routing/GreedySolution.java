package com.stackroute.routing;

import java.util.ArrayList;

public class GreedySolution {

    int noOfVehicles;
    int noOfOrders;
    Vehicle[] vehicles; //vehicle array
    double cost;

    //Tabu Variables
    //public Vehicle[] vehiclesForBestRoute; //after tabu search best routes
    //double bestSolutionCost; //after tabu search best cost

    public ArrayList<Double> pastSolutions; //array of greedy solutions

    GreedySolution(int orderNo, int vehicleNo , int vehicleCap ){
        this.noOfVehicles = vehicleNo;
        this.noOfOrders = orderNo;
        this.cost = 0;
        vehicles = new Vehicle[noOfVehicles]; //initialising all vehicles array.
       // vehiclesForBestRoute = new Vehicle[noOfVehicles]; //initializing best route vehicles.
        pastSolutions = new ArrayList<>(); //to record all routes.

        for(int i = 0; i < noOfVehicles; i++){
            vehicles[i] = new Vehicle(i+1,vehicleCap);
        }
    }

    public boolean unassignedOrderExists(Node[] nodes){
        //chechking all nodes
        for(int i = 1; i< nodes.length; i++) {
            //if node doesnot have any route
            if (!nodes[i].isRouted) {
                return true;
            }
        }
        return false;
    }

    public double greedySolution(Node[] nodes , double[][] costMatrix){
        double orderCost, endCost;
        int vehIndex = 0;

        while (unassignedOrderExists(nodes)){
            int orderIndex = 0;
            Node newOrder = null;
            double minCost = (float) Double.MAX_VALUE;

            if(vehicles[vehIndex].Route.isEmpty()){
                vehicles[vehIndex].addNode(nodes[0]);
            }

            for (int i = 1; i<= noOfOrders; i++){
                if(nodes[i].isRouted == false){
                    if(vehicles[vehIndex].checkIfFits(nodes[i].demand)){
                        orderCost = costMatrix[vehicles[vehIndex].currentLoc][i];
                        if(minCost > orderCost){
                            minCost = orderCost;
                            orderIndex = i;
                            newOrder = nodes[i];
                        }
                    }
                }
            }

            //not a single customer fits
            if ( newOrder == null){
                //we have more vehicles to assign
                if( vehIndex+1 < vehicles.length){
                    //end this route
                    if (vehicles[vehIndex].currentLoc != 0){
                        endCost = costMatrix[vehicles[vehIndex].currentLoc][0];
                        vehicles[vehIndex].addNode(nodes[0]);
                        this.cost += endCost;
                    }
                    vehIndex = vehIndex+1; //go to next vehicle
                }
                else //we do not have any more vehicles to assign.
                {
                    System.out.println("Order does not fit in truck ");
                    System.exit(0);
                }
            }else {
                vehicles[vehIndex].addNode(newOrder); //if Order fits
                nodes[orderIndex].isRouted = true;
                this.cost += minCost;
            }
        }
        endCost = costMatrix[vehicles[vehIndex].currentLoc][0];
        vehicles[vehIndex].addNode(nodes[0]);
        this.cost += endCost;
        return endCost;
    }

}
