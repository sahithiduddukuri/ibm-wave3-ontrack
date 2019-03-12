package com.stackroute.routingmanager.Service;
import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Vehicle;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SolutionAlgos {
    int noOfvehicles ;
    int noOfOrders;
    Vehicle[] vehicles;
    double cost;
    //Tabu Variables
    public Vehicle[] vehiclesForBestSolution;
    double bestSolutionCost;
    public ArrayList<Double> pastSolutions;
    SolutionAlgos(int orderNum, int vechNum , int vechCap)
    {
        this.noOfvehicles = vechNum;
        this.noOfOrders = orderNum;
        this.cost = 0;
        vehicles = new Vehicle[noOfvehicles];
        vehiclesForBestSolution =  new Vehicle[noOfvehicles];
        pastSolutions = new ArrayList<>();
        for (int i = 0 ; i < noOfvehicles; i++)
        {
            vehicles[i] = new Vehicle(i+1,vechCap);
            vehiclesForBestSolution[i] = new Vehicle(i+1,vechCap);
        }
    }
    public boolean unassignedOrderExists(Node[] nodes)
    {
        System.out.println("node length is ####################"+nodes.length);
        for (int i = 1; i < nodes.length; i++)
        {
            if (!nodes[i].isRouted)
                return true;
        }
        return false;
    }
    public void greedySolution(Node[] nodes , double[][] costMatrix) {
        double oandCost,endCost;
        int vehIndex = 0;
        while (unassignedOrderExists(nodes)) {
            int orderIndex = 0;
            Node Candidate = null;
            double minCost = (float) Double.MAX_VALUE;
            if (vehicles[vehIndex].Route.isEmpty())
            {
                vehicles[vehIndex].addNode(nodes[0]);
            }
            for (int i = 1; i <= noOfOrders-3; i++) {
                if (nodes[i].isRouted == false) {
                    if (vehicles[vehIndex].CheckIfFits(nodes[i].demand)) {
                        oandCost = costMatrix[vehicles[vehIndex].curLoc][i];
                        if (minCost > oandCost) {
                            minCost = oandCost;
                            orderIndex = i;
                            Candidate = nodes[i];
                        }
                    }
                }
            }
            if ( Candidate  == null)
            {
                //Not a single Customer Fits
                if ( vehIndex+1 < vehicles.length ) //We have more vehicles to assign
                {
                    if (vehicles[vehIndex].curLoc != 0) {//End this route
                        endCost = costMatrix[vehicles[vehIndex].curLoc][0];
                        vehicles[vehIndex].addNode(nodes[0]);
                        this.cost +=  endCost;
                    }
                    vehIndex = vehIndex+1; //Go to next Vehicle
                }
                else //We DO NOT have any more vehicle to assign. The problem is unsolved under these parameters
                {
                    System.out.println("\nThe rest customers do not fit in any Vehicle\n" +
                            "The problem cannot be resolved under these constrains");
                    System.exit(0);
                }
            }
            else
            {
                vehicles[vehIndex].addNode(Candidate);//If a fitting Customer is Found
                nodes[orderIndex].isRouted = true;
                this.cost += minCost;
            }
        }
        endCost = costMatrix[vehicles[vehIndex].curLoc][0];
        vehicles[vehIndex].addNode(nodes[0]);
        this.cost +=  endCost;
    }
    public void tabuSearch(int TABU_Horizon, double[][] costMatrix) {
        //We use 1-0 exchange move
        ArrayList<Node> routeFrom;
        ArrayList<Node> routeTo;
        int movingNodeDemand = 0;
        int vehIndexFrom,vehIndexTo;
        double bestNCost,neigthborCost;
        int swapIndexA = -1, swapIndexB = -1, swapRouteFrom = -1, swapRouteTo= -1;
        int MAX_ITERATIONS = 200;
        int iteration_number= 0;
        int DimensionCustomer = costMatrix[1].length;
        int TABU_Matrix[][] = new int[DimensionCustomer+1][DimensionCustomer+1];
        bestSolutionCost = this.cost; //Initial Solution Cost
        boolean termination = false;
        while (!termination)
        {
            iteration_number++;
            bestNCost = Double.MAX_VALUE;
            for (vehIndexFrom = 0;  vehIndexFrom <  this.vehicles.length;  vehIndexFrom++) {
                routeFrom =  this.vehicles[vehIndexFrom].Route;
                int routFromLength = routeFrom.size();
                for (int i = 1; i < routFromLength - 1; i++) { //Not possible to move depot!
                    for (vehIndexTo = 0; vehIndexTo <  this.vehicles.length; vehIndexTo++) {
                        routeTo =   this.vehicles[vehIndexTo].Route;
                        int routeTolength = routeTo.size();
                        for (int j = 0; (j < routeTolength - 1); j++) {//Not possible to move after last Depot!
                            movingNodeDemand = routeFrom.get(i).demand;
                            if ((vehIndexFrom == vehIndexTo) ||  this.vehicles[vehIndexTo].CheckIfFits(movingNodeDemand)) {
                                //If we assign to a different route check capacity constrains
                                //if in the new route is the same no need to check for capacity
                                if (((vehIndexFrom == vehIndexTo) && ((j == i) || (j == i - 1))) == false)  // Not a move that Changes solution cost
                                {
                                    double MinusCost1 = costMatrix[routeFrom.get(i - 1).nodeId][routeFrom.get(i).nodeId];
                                    double MinusCost2 = costMatrix[routeFrom.get(i).nodeId][routeFrom.get(i + 1).nodeId];
                                    double MinusCost3 = costMatrix[routeTo.get(j).nodeId][routeTo.get(j + 1).nodeId];
                                    double AddedCost1 = costMatrix[routeFrom.get(i - 1).nodeId][routeFrom.get(i + 1).nodeId];
                                    double AddedCost2 = costMatrix[routeTo.get(j).nodeId][routeFrom.get(i).nodeId];
                                    double AddedCost3 = costMatrix[routeFrom.get(i).nodeId][routeTo.get(j + 1).nodeId];
                                    //Check if the move is a Tabu! - If it is Tabu break
                                    if ((TABU_Matrix[routeFrom.get(i - 1).nodeId][routeFrom.get(i+1).nodeId] != 0)
                                            || (TABU_Matrix[routeTo.get(j).nodeId][routeFrom.get(i).nodeId] != 0)
                                            || (TABU_Matrix[routeFrom.get(i).nodeId][routeTo.get(j+1).nodeId] != 0)) {
                                        break;
                                    }
                                    neigthborCost = AddedCost1 + AddedCost2 + AddedCost3
                                            - MinusCost1 - MinusCost2 - MinusCost3;
                                    if (neigthborCost < bestNCost) {
                                        bestNCost = neigthborCost;
                                        swapIndexA = i;
                                        swapIndexB = j;
                                        swapRouteFrom = vehIndexFrom;
                                        swapRouteTo = vehIndexTo;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int o = 0; o < TABU_Matrix[0].length;  o++) {
                for (int p = 0; p < TABU_Matrix[0].length ; p++) {
                    if (TABU_Matrix[o][p] > 0)
                    { TABU_Matrix[o][p]--; }
                }
            }
            routeFrom =  this.vehicles[swapRouteFrom].Route;
            routeTo =  this.vehicles[swapRouteTo].Route;
            this.vehicles[swapRouteFrom].Route = null;
            this.vehicles[swapRouteTo].Route = null;
            Node SwapNode = routeFrom.get(swapIndexA);
            int NodeIDBefore = routeFrom.get(swapIndexA-1).nodeId;
            int NodeIDAfter = routeFrom.get(swapIndexA+1).nodeId;
            int NodeID_F = routeTo.get(swapIndexB).nodeId;
            int NodeID_G = routeTo.get(swapIndexB+1).nodeId;
            Random TabuRan = new Random();
            int RendomDelay1 = TabuRan.nextInt(5);
            int RendomDelay2 = TabuRan.nextInt(5);
            int RendomDelay3 = TabuRan.nextInt(5);
            TABU_Matrix[NodeIDBefore][SwapNode.nodeId] = TABU_Horizon + RendomDelay1;
            TABU_Matrix[SwapNode.nodeId][NodeIDAfter]  = TABU_Horizon + RendomDelay2 ;
            TABU_Matrix[NodeID_F][NodeID_G] = TABU_Horizon + RendomDelay3;
            routeFrom.remove(swapIndexA);
            if (swapRouteFrom == swapRouteTo) {
                if (swapIndexA < swapIndexB) {
                    routeTo.add(swapIndexB, SwapNode);
                } else {
                    routeTo.add(swapIndexB + 1, SwapNode);
                }
            }
            else
            {
                routeTo.add(swapIndexB+1, SwapNode);
            }
            this.vehicles[swapRouteFrom].Route = routeFrom;
            this.vehicles[swapRouteFrom].load -= movingNodeDemand;
            this.vehicles[swapRouteTo].Route = routeTo;
            this.vehicles[swapRouteTo].load += movingNodeDemand;
            pastSolutions.add(this.cost);
            this.cost  += bestNCost;
            if (this.cost <   bestSolutionCost)
            {
                saveBestSolution();
            }
            if (iteration_number == MAX_ITERATIONS)
            { termination = true;
            }
        }
        this.vehicles = vehiclesForBestSolution;
        this.cost = bestSolutionCost;
        try{
            PrintWriter writer = new PrintWriter("PastSolutionsTabu.txt", "UTF-8");
            writer.println("Solutions"+"\t");
            for  (int i = 0; i< pastSolutions.size(); i++){
                writer.println(pastSolutions.get(i)+"\t");
            }
            writer.close();
        } catch (Exception e) {}
    }
    public void saveBestSolution()
    {
        bestSolutionCost = cost;
        for (int j=0 ; j < noOfvehicles ; j++)
        {
            vehiclesForBestSolution[j].Route.clear();
            if (! vehicles[j].Route.isEmpty())
            {
                int RoutSize = vehicles[j].Route.size();
                for (int k = 0; k < RoutSize ; k++) {
                    Node n = vehicles[j].Route.get(k);
                    vehiclesForBestSolution[j].Route.add(n);
                }
            }
        }
    }
    public List<Vehicle> solutionPrint(String label)//Print Solution In console
    {
        System.out.println("=========================================================");
        System.out.println(label + " \n");
        List<Vehicle> nodeList = new ArrayList<>();
        for (int j=0 ; j < noOfvehicles ; j++)
        {
            if (!vehicles[j].Route.isEmpty())
            {
                System.out.print("Vehicle " + j + ":");
                int RoutSize = vehicles[j].Route.size();
                for (int k = 0; k < RoutSize ; k++) {
                    if (k == RoutSize-1)
                    {
                        System.out.println("node value is ++++++++++++++++++++++"+vehicles[j]);
                        System.out.print(vehicles[j].Route.get(k).nodeId );  }
                    else
                    { System.out.print(vehicles[j].Route.get(k).nodeId+ "->"); }
                }
                System.out.println();
            }
            nodeList.add(vehicles[j]);
            vehicles[j].setCost(this.cost);
            System.out.println("hiiiiiiiiiiiiiiiiiiii"+vehicles[j].getRoute());
        }
        System.out.println("This is the list of nodes ######@@@@@@@@@@@@#######"+nodeList);
        System.out.println("\nSolution Cost "+this.cost+"\n");
//        return "Routes Created";
        return nodeList;
    }
}



