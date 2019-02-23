package com.stackroute.routing;

import com.stackroute.routing.domain.Node;
import com.stackroute.routing.domain.Vehicle;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class TabuSearch {

    int noOfVehicles;
    int noOfOrders;
    Vehicle[] vehicles; //vehicle array
    double cost;

    //Tabu Variables
    public Vehicle[] vehiclesForBestRoute; //after tabu search best routes
    double bestSolutionCost; //after tabu search best cost

    public ArrayList<Double> pastSolutions; //array of greedy solutions

    TabuSearch(int orderNo, int vehicleNo , int vehicleCap ){
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



    //GreedySolution greedySolution = new GreedySolution();
    //Tabu parameter for tabu search
    int tabu_horizon = 10;

    public void tabuSearchAlgo(int tabu_horizon, double[][] costMatrix) {

        //We use 1-0 exchange move
        ArrayList<Node> routeFrom;
        ArrayList<Node> routeTo;

        int movingNodeDemand = 0;

        int vehicleIndexFrom , vehicleIndexTo;
        double bestNodeCost , neighborCost;

        int swapIndexA = -1, swapIndexB = -1, swapRouteFrom = -1, swapRouteTo = -1;

        int maxIterations = 200;
        int iterationNumber = 0;

        int dimensionOrder = costMatrix[1].length;

        int tabuMatrix[][] = new int[dimensionOrder+1][dimensionOrder+1];

        bestSolutionCost = this.cost; //initial cost

        boolean termination = false;

        while (!termination){

            iterationNumber++;
            bestNodeCost = Double.MAX_VALUE;

            for (vehicleIndexFrom = 0; vehicleIndexFrom < this.vehicles.length; vehicleIndexFrom++) {
                routeFrom = this.vehicles[vehicleIndexFrom].Route;
                int routeFromLength = routeFrom.size();
                for(int i = 1; i < routeFromLength - 1; i++) { //not possible to move depot...

                    for (vehicleIndexTo = 0; vehicleIndexTo < this.vehicles.length; vehicleIndexTo++) {
                        routeTo = this.vehicles[vehicleIndexTo].Route;
                        int routeTolength = routeTo.size();
                        for (int j = 0;(j <routeTolength -1); j++) { //not possible to move after last depot
                            movingNodeDemand = routeFrom.get(i).demand;

                            if((vehicleIndexFrom == vehicleIndexTo) || this.vehicles[vehicleIndexTo].checkIfFits(movingNodeDemand)) {
                                double minusCost1 = costMatrix[routeFrom.get(i - 1).nodeId][routeFrom.get(i).nodeId];
                                double minusCost2 = costMatrix[routeFrom.get(i).nodeId][routeFrom.get(i + 1).nodeId];
                                double minusCost3 = costMatrix[routeTo.get(j).nodeId][routeTo.get(j + 1).nodeId];

                                double addedCost1 = costMatrix[routeFrom.get(i - 1).nodeId][routeFrom.get(i + 1).nodeId];
                                double addedCost2 = costMatrix[routeTo.get(j).nodeId][routeFrom.get(i).nodeId];
                                double addedCost3 = costMatrix[routeFrom.get(i).nodeId][routeTo.get(j + 1).nodeId];

                                //check for tabu move and break
                                if ((tabuMatrix[routeFrom.get(i - 1).nodeId][routeFrom.get(i + 1).nodeId] != 0)
                                || (tabuMatrix[routeTo.get(j).nodeId][routeFrom.get(i).nodeId] != 0)
                                || (tabuMatrix[routeFrom.get(i).nodeId][routeTo.get(j + 1).nodeId] != 0)) {
                                    break;
                                }
                                neighborCost = addedCost1 + addedCost2 + addedCost3 - minusCost1 - minusCost2 - minusCost3;

                                if (neighborCost < bestNodeCost) {
                                    bestNodeCost = neighborCost;
                                    swapIndexA = i;
                                    swapIndexB = j;
                                    swapRouteFrom = vehicleIndexFrom;
                                    swapRouteTo = vehicleIndexTo;
                                }
                            }
                        }
                    }
                }
            }
            for (int o = 0; o<tabuMatrix[0].length; o++) {
                for (int p = 0; p<tabuMatrix[0].length ; p++) {
                    if (tabuMatrix[o][p] > 0){
                        tabuMatrix[o][p]--;
                    }
                }
            }

            routeFrom = this.vehicles[swapRouteFrom].Route;
            routeTo = this.vehicles[swapRouteTo].Route;
            this.vehicles[swapRouteFrom].Route = null;
            this.vehicles[swapRouteTo].Route = null;

            Node swapNode = routeFrom.get(swapIndexA);

            int nodeIDBefore = routeFrom.get(swapIndexA-1).nodeId;
            int nodeIDAfter = routeFrom.get(swapIndexA+1).nodeId;
            int nodeID_F = routeTo.get(swapIndexB).nodeId;
            int nodeID_G = routeTo.get(swapIndexB+1).nodeId;

            Random TabuRan = new Random();
            int randomDelay1 = TabuRan.nextInt(5);
            int randomDelay2 = TabuRan.nextInt(5);
            int randomDelay3 = TabuRan.nextInt(5);

            tabuMatrix[nodeIDBefore][swapNode.nodeId] = tabu_horizon + randomDelay1;
            tabuMatrix[swapNode.nodeId][nodeIDAfter] = tabu_horizon + randomDelay2;
            tabuMatrix[nodeID_F][nodeID_G] = tabu_horizon + randomDelay3;

            routeFrom.remove(swapIndexA);

            if (swapRouteFrom == swapRouteTo) {
                if (swapIndexA < swapIndexB) {
                    routeTo.add(swapIndexB,swapNode);
                } else {
                    routeTo.add(swapIndexB + 1,swapNode);
                }
            } else {
                routeTo.add(swapIndexB+1,swapNode);
            }

            this.vehicles[swapRouteFrom].Route = routeFrom;
            this.vehicles[swapRouteFrom].load -= movingNodeDemand;

            this.vehicles[swapRouteTo].Route = routeTo;
            this.vehicles[swapRouteTo].load += movingNodeDemand;

            pastSolutions.add(this.cost);
            this.cost += bestNodeCost;

            if (this.cost < bestSolutionCost){
                saveBestSolution();
            }
            if(iterationNumber == maxIterations) {
                termination = true;
            }
        }

        this.vehicles = vehiclesForBestRoute;
        this.cost = bestSolutionCost;

        try {
            PrintWriter writer = new PrintWriter("pastSolutionsTabu.txt","UTF-8");
            writer.println("Solutions"+"\t");
            for (int i = 0; i<pastSolutions.size(); i++) {
                writer.println(pastSolutions.get(i)+"\t");
            }
            writer.close();
        }catch (Exception e) {

        }




    }
    public void saveBestSolution() {
        bestSolutionCost = cost;
        for (int j=0 ; j<noOfVehicles; j++) {
            vehiclesForBestRoute[j].Route.clear();
            if (! vehicles[j].Route.isEmpty()) {
                int routeSize = vehicles[j].Route.size();
                for (int k = 0 ; k < routeSize ; k++) {
                    Node n = vehicles[j].Route.get(k);
                    vehiclesForBestRoute[j].Route.add(n);
                }
            }
        }
    }
}
