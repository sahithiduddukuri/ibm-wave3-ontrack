package com.stackroute.routing;

import com.stackroute.routing.domain.Container;
import com.stackroute.routing.domain.Node;
import com.stackroute.routing.domain.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class Solution {

    private Random random = new Random(151190);

    //For demo hard coded parameters
    int noOfOrders ;
    int noOfVehicles ;
    int noOfContainers = 5;
    int vehicleCapacity;
    int containerCapacity ;

    //Depot Co-ordinates
    int depot_x = 50;
    int depot_y = 50;

    Vehicle[] vehicles; //vehicle array
    double cost;


    //node array
    Node[] nodes;
    Node[] tempNodes;

    public ArrayList<Double> pastSolutions; //array of greedy solutions

   //container array
    ArrayList containers = new ArrayList();

    Solution(int noOfOrders, int noOfVehicles , int vehicleCap , int containerCap){
        this.noOfVehicles = noOfVehicles;
        this.noOfOrders = noOfOrders;
        this.cost = 0;
        this.vehicleCapacity = vehicleCap;
        this.containerCapacity = containerCap;
/*
        vehicles = new Vehicle[noOfVehicles]; //initialising all vehicles array.
        // vehiclesForBestRoute = new Vehicle[noOfVehicles]; //initializing best route vehicles.
        pastSolutions = new ArrayList<>(); //to record all routes.

        for(int i = 0; i < noOfVehicles; i++){
            vehicles[i] = new Vehicle(i+1,vehicleCap);
        }


       *//* for(int i = 1; i<= noOfOrders; i++) {
            nodes[i] = new Node(i,
                    random.nextInt(100),
                    random.nextInt(100),
                    4 + random.nextInt(7)
            );
        }*//*

        for (int j=0 ; j<noOfContainers ; j++ ) {
            containers[j] = new Container(j+1, containerCapacity, nodes);
        }*/

    }

 //opening container and getting orders as nodes
    public  Node[] getNodes() {

        Node nodes[] = new Node[noOfOrders + 1];
        Node depot = new Node(depot_x,depot_y);

        nodes[0] = depot; //making first node as warehouse depot location.

        for ( int i=0 ; i<noOfContainers ; i++) {
            for ( int j= 1 ; j<noOfOrders +1 ; j++) {
                nodes[i] = new Node(i,
                        random.nextInt(100),
                        random.nextInt(100),
                        4 + random.nextInt(7)
                );
                System.out.println("node: "+nodes[i].getNodeId()+" ");
            }
        }

        return nodes;

    }





//adding nodes(orders) to containers based on location
    public void containerFilling()  {

       getNodes();
        for( int i = 0 ; i<containers.size() ; i++) {
            for (int j=0 ; j<containerCapacity; j++) {
                if (nodes[i].node_x == nodes[j].node_x ) {
                    if (nodes[i].node_y == nodes[j].node_y ) {
                        for ( int k=1 ; k<=nodes.length ; k++) {
                           //logic to add node into container......
                            for(int l=1; l<=nodes.length; l++) {
                                tempNodes[l] = nodes[l];
                            }

                            System.out.println();

                        }
                    }
                }
            }
            System.out.println("container change" );
        }

    }
/*
//calculationf distance between nodes and storing in double[][] matrix
    public double[][] calculateDistance(){
        System.out.println("inside distance class");


        double[][] distanceMatrix = new double[noOfOrders + 1][noOfOrders + 1];
        double delta_x,delta_y;
        for(int i = 0; i<= noOfOrders; i++){
            for(int j = i+1; j<=noOfOrders; j++){
                //depot to next neighbor
                delta_x = (nodes[i].node_x - nodes[j].node_x);
                delta_y = (nodes[i].node_y - nodes[j].node_y);

                double distance = Math.sqrt((delta_x * delta_x) + (delta_y * delta_y));
                distance = Math.round(distance); //to get distance in nearest integer value

                distanceMatrix[i][j] = distance;
                distanceMatrix[j][i] = distance;

            }
        }



        double printMatrix[][] = new double[noOfOrders + 1][noOfOrders + 1]; //to print distance matrix.
        for (int i =0; i<=noOfOrders; i++){
            for (int j=0; j<=noOfOrders; j++){
                printMatrix[i][j] = distanceMatrix[i][j];
                System.out.print(distanceMatrix[i][j] + "-");
            }
            System.out.println();
        }


        return printMatrix;
    }


//check if a node is not enrouted...
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
    }*/

}
