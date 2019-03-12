package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptimizedSolutionImpl implements OptimizedSolution {

    Order order;

    @Override
    public List<Vehicle> optimizedCost(int noOfOrders , List<Node> nodeList,List<Integer> demand) {

        Random ran = new Random(151190);

        System.out.println("no Of Order value is++++++++++++++"+demand+"demeand size#######3$$$$$%%%%"+demand.size() );

        //Problem Parameters
        int noOfNodes = noOfOrders;
        int noOfVehicles = 2;
        int vehicleCap = 100;

        //Depot Coordinates
        double depot_x = 50;
        double depot_y = 50;

        //Tabu Parameter
        int TABU_Horizon = 10;

        //Initialise
        //Create Random Customers
        Node[] nodes = new Node[noOfNodes-3 + 1];
        Node depot = new Node(depot_x, depot_y);

        nodes[0] = depot;
        for (int i = 1; i <= noOfNodes-3; i++) {
            System.out.println("@@@@@##############$$$$$$$$$$$$$$%%%%%%check its calling in forloop#########$$$$$%%%%%%%%%%%%");
//            nodes[i] = new Node(i, //Id ) is reserved for depot
//                    ran.nextInt(x), //Random Cordinates
//                    ran.nextInt(y),
//                    demand);  //Random Demand
            nodes[i] = new Node(i,nodeList.get(i).node_X,nodeList.get(i).node_Y,demand.get(i));

        }

        double[][] distanceMatrix = new double[noOfNodes + 1][noOfNodes + 1];
        double delta_x, delta_y;
        for (int i = 0; i <= noOfNodes-3; i++) {
            for (int j = i + 1; j <= noOfNodes-3; j++) //The table is summetric to the first diagonal
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
            for (int i = 0; i <= noOfNodes-3; i++) {
                for (int j = 0; j <= noOfNodes-3; j++) {
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

        List<Vehicle> nodes1 = s.solutionPrint( "Greedy_Solution" );

        System.out.println("this Sout is in optimized solution class^^^^^^$$$$$$$$$$$$$^^^^^^^^^^^^"+nodes1);

//        draw.drawRoutes(s, "Greedy_Solution");



//        s.tabuSearch(TABU_Horizon, distanceMatrix);
//
//        s.solutionPrint( "Tabu Search" );

//        draw.drawRoutes(s, "TABU_Solution");
//      return "routing done";
        return nodes1;
    }
}