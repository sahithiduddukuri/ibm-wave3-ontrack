package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Domain.Vehicle;
import java.util.ArrayList;
import java.util.Random;

public class OptimizedSolutionImpl {

    Order order;

    public String optimizedCost(int noOfOrders , int x , int y , int demand) {



        //Problem Parameters
        int noOfNodes = noOfOrders;
        int noOfVehicles = 5;
        int vehicleCap = 100;

        //Depot Coordinates
        int depot_x = 50;
        int depot_y = 50;

        //Tabu Parameter
        int TABU_Horizon = 10;

        //Initialise
        //Create Random Customers
        Node[] nodes = new Node[noOfNodes + 1];
        Node depot = new Node(depot_x, depot_y);

        nodes[0] = depot;
        for (int i = 1; i <= noOfNodes; i++) {
            nodes[i] = new Node(i, //Id ) is reserved for depot
                    x, //Random Cordinates
                    y,
                    demand);  //Random Demand

        }

        double[][] distanceMatrix = new double[noOfNodes + 1][noOfNodes + 1];
        double delta_x, delta_y;
        for (int i = 0; i <= noOfNodes; i++) {
            for (int j = i + 1; j <= noOfNodes; j++) //The table is summetric to the first diagonal
            {                                      //Use this to compute distances in O(n/2)

                delta_x = (nodes[i].node_X - nodes[j].node_X);
                delta_y = (nodes[i].node_Y - nodes[j].node_Y);

                double distance = Math.sqrt((delta_x * delta_x) + (delta_y * delta_y));

                distance = Math.round(distance);                //Distance is Casted in Integer
                //distance = Math.round(distance*100.0)/100.0; //Distance in double

                distanceMatrix[i][j] = distance;
                distanceMatrix[j][i] = distance;
            }
        }
        int printMatrix = 0; //If we want to print diastance matrix

        if (printMatrix == 1) {
            for (int i = 0; i <= noOfNodes; i++) {
                for (int j = 0; j <= noOfNodes; j++) {
                    System.out.print(distanceMatrix[i][j] + "  ");
                }
                System.out.println();
            }
        }

        //Compute the greedy Solution
        System.out.println("Attempting to resolve Vehicle Routing Problem (VRP) for " + noOfNodes +
                " Customers and " + noOfVehicles + " Vehicles" + " with " + vehicleCap + " units of capacity\n");

        SolutionAlgos s = new SolutionAlgos(noOfNodes, noOfVehicles, vehicleCap);

        s.greedySolution(nodes, distanceMatrix);

        s.solutionPrint( "Greedy_Solution" );

//        draw.drawRoutes(s, "Greedy_Solution");



        s.tabuSearch(TABU_Horizon, distanceMatrix);

        s.solutionPrint( "Tabu Search" );

//        draw.drawRoutes(s, "TABU_Solution");
      return "routing done";
    }
}







