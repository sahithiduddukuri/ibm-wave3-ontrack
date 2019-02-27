package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Vehicle;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class OptimizedSolutionImpl implements OptimizedSolution {

    int NoOfVehicles;
    int NoOfCustomers;
    Vehicle[] Vehicles;
    double Cost;

    //Tabu Variables
    public Vehicle[] VehiclesForBestSolution;
    double BestSolutionCost;

    public ArrayList<Double> PastSolutions;

    OptimizedSolutionImpl(int CustNum, int VechNum , int VechCap)
    {
        this.NoOfVehicles = VechNum;
        this.NoOfCustomers = CustNum;
        this.Cost = 0;
        Vehicles = new Vehicle[NoOfVehicles];
        VehiclesForBestSolution =  new Vehicle[NoOfVehicles];
        PastSolutions = new ArrayList<>();

        for (int i = 0 ; i < NoOfVehicles; i++)
        {
            Vehicles[i] = new Vehicle(i+1,VechCap);
            VehiclesForBestSolution[i] = new Vehicle(i+1,VechCap);
        }
    }

    @Override
    public boolean UnassignedCustomerExists(Node[] Nodes)
    {
        for (int i = 1; i < Nodes.length; i++)
        {
            if (!Nodes[i].isRouted)
                return true;
        }
        return false;
    }

    @Override
    public void GreedySolution(Node[] Nodes , double[][] CostMatrix) {

        double CandCost,EndCost;
        int VehIndex = 0;

        while (UnassignedCustomerExists(Nodes)) {

            int CustIndex = 0;
            Node Candidate = null;
            double minCost = (float) Double.MAX_VALUE;

            if (Vehicles[VehIndex].Route.isEmpty())
            {
                Vehicles[VehIndex].addNode(Nodes[0]);
            }

            for (int i = 1; i <= NoOfCustomers; i++) {
                if (Nodes[i].isRouted == false) {
                    if (Vehicles[VehIndex].CheckIfFits(Nodes[i].demand)) {
                        CandCost = CostMatrix[Vehicles[VehIndex].CurLoc][i];
                        if (minCost > CandCost) {
                            minCost = CandCost;
                            CustIndex = i;
                            Candidate = Nodes[i];
                        }
                    }
                }
            }

            if ( Candidate  == null)
            {
                //Not a single Customer Fits
                if ( VehIndex+1 < Vehicles.length ) //We have more vehicles to assign
                {
                    if (Vehicles[VehIndex].CurLoc != 0) {//End this route
                        EndCost = CostMatrix[Vehicles[VehIndex].CurLoc][0];
                        Vehicles[VehIndex].addNode(Nodes[0]);
                        this.Cost +=  EndCost;
                    }
                    VehIndex = VehIndex+1; //Go to next Vehicle
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
                Vehicles[VehIndex].addNode(Candidate);//If a fitting Customer is Found
                Nodes[CustIndex].isRouted = true;
                this.Cost += minCost;
            }
        }

        EndCost = CostMatrix[Vehicles[VehIndex].CurLoc][0];
        Vehicles[VehIndex].addNode(Nodes[0]);
        this.Cost +=  EndCost;

    }

    @Override
    public void TabuSearch(int TABU_Horizon, double[][] CostMatrix) {

        //We use 1-0 exchange move
        ArrayList<Node> RouteFrom;
        ArrayList<Node> RouteTo;

        int MovingNodeDemand = 0;

        int VehIndexFrom,VehIndexTo;
        double BestNCost,NeigthboorCost;

        int SwapIndexA = -1, SwapIndexB = -1, SwapRouteFrom =-1, SwapRouteTo=-1;

        int MAX_ITERATIONS = 200;
        int iteration_number= 0;

        int DimensionCustomer = CostMatrix[1].length;
        int TABU_Matrix[][] = new int[DimensionCustomer+1][DimensionCustomer+1];

        BestSolutionCost = this.Cost; //Initial Solution Cost

        boolean Termination = false;

        while (!Termination)
        {
            iteration_number++;
            BestNCost = Double.MAX_VALUE;

            for (VehIndexFrom = 0;  VehIndexFrom <  this.Vehicles.length;  VehIndexFrom++) {
                RouteFrom =  this.Vehicles[VehIndexFrom].Route;
                int RoutFromLength = RouteFrom.size();
                for (int i = 1; i < RoutFromLength - 1; i++) { //Not possible to move depot!

                    for (VehIndexTo = 0; VehIndexTo <  this.Vehicles.length; VehIndexTo++) {
                        RouteTo =   this.Vehicles[VehIndexTo].Route;
                        int RouteTolength = RouteTo.size();
                        for (int j = 0; (j < RouteTolength - 1); j++) {//Not possible to move after last Depot!

                            MovingNodeDemand = RouteFrom.get(i).demand;

                            if ((VehIndexFrom == VehIndexTo) ||  this.Vehicles[VehIndexTo].CheckIfFits(MovingNodeDemand)) {
                                //If we assign to a different route check capacity constrains
                                //if in the new route is the same no need to check for capacity

                                if (((VehIndexFrom == VehIndexTo) && ((j == i) || (j == i - 1))) == false)  // Not a move that Changes solution cost
                                {
                                    double MinusCost1 = CostMatrix[RouteFrom.get(i - 1).nodeId][RouteFrom.get(i).nodeId];
                                    double MinusCost2 = CostMatrix[RouteFrom.get(i).nodeId][RouteFrom.get(i + 1).nodeId];
                                    double MinusCost3 = CostMatrix[RouteTo.get(j).nodeId][RouteTo.get(j + 1).nodeId];

                                    double AddedCost1 = CostMatrix[RouteFrom.get(i - 1).nodeId][RouteFrom.get(i + 1).nodeId];
                                    double AddedCost2 = CostMatrix[RouteTo.get(j).nodeId][RouteFrom.get(i).nodeId];
                                    double AddedCost3 = CostMatrix[RouteFrom.get(i).nodeId][RouteTo.get(j + 1).nodeId];

                                    //Check if the move is a Tabu! - If it is Tabu break
                                    if ((TABU_Matrix[RouteFrom.get(i - 1).nodeId][RouteFrom.get(i+1).nodeId] != 0)
                                            || (TABU_Matrix[RouteTo.get(j).nodeId][RouteFrom.get(i).nodeId] != 0)
                                            || (TABU_Matrix[RouteFrom.get(i).nodeId][RouteTo.get(j+1).nodeId] != 0)) {
                                        break;
                                    }

                                    NeigthboorCost = AddedCost1 + AddedCost2 + AddedCost3
                                            - MinusCost1 - MinusCost2 - MinusCost3;

                                    if (NeigthboorCost < BestNCost) {
                                        BestNCost = NeigthboorCost;
                                        SwapIndexA = i;
                                        SwapIndexB = j;
                                        SwapRouteFrom = VehIndexFrom;
                                        SwapRouteTo = VehIndexTo;
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

            RouteFrom =  this.Vehicles[SwapRouteFrom].Route;
            RouteTo =  this.Vehicles[SwapRouteTo].Route;
            this.Vehicles[SwapRouteFrom].Route = null;
            this.Vehicles[SwapRouteTo].Route = null;

            Node SwapNode = RouteFrom.get(SwapIndexA);

            int NodeIDBefore = RouteFrom.get(SwapIndexA-1).nodeId;
            int NodeIDAfter = RouteFrom.get(SwapIndexA+1).nodeId;
            int NodeID_F = RouteTo.get(SwapIndexB).nodeId;
            int NodeID_G = RouteTo.get(SwapIndexB+1).nodeId;

            Random TabuRan = new Random();
            int RendomDelay1 = TabuRan.nextInt(5);
            int RendomDelay2 = TabuRan.nextInt(5);
            int RendomDelay3 = TabuRan.nextInt(5);

            TABU_Matrix[NodeIDBefore][SwapNode.nodeId] = TABU_Horizon + RendomDelay1;
            TABU_Matrix[SwapNode.nodeId][NodeIDAfter]  = TABU_Horizon + RendomDelay2 ;
            TABU_Matrix[NodeID_F][NodeID_G] = TABU_Horizon + RendomDelay3;

            RouteFrom.remove(SwapIndexA);

            if (SwapRouteFrom == SwapRouteTo) {
                if (SwapIndexA < SwapIndexB) {
                    RouteTo.add(SwapIndexB, SwapNode);
                } else {
                    RouteTo.add(SwapIndexB + 1, SwapNode);
                }
            }
            else
            {
                RouteTo.add(SwapIndexB+1, SwapNode);
            }


            this.Vehicles[SwapRouteFrom].Route = RouteFrom;
            this.Vehicles[SwapRouteFrom].load -= MovingNodeDemand;

            this.Vehicles[SwapRouteTo].Route = RouteTo;
            this.Vehicles[SwapRouteTo].load += MovingNodeDemand;

            PastSolutions.add(this.Cost);

            this.Cost  += BestNCost;

            if (this.Cost <   BestSolutionCost)
            {
                SaveBestSolution();
            }

            if (iteration_number == MAX_ITERATIONS)
            {
                Termination = true;
            }
        }

        this.Vehicles = VehiclesForBestSolution;
        this.Cost = BestSolutionCost;

        try{
            PrintWriter writer = new PrintWriter("PastSolutionsTabu.txt", "UTF-8");
            writer.println("Solutions"+"\t");
            for  (int i = 0; i< PastSolutions.size(); i++){
                writer.println(PastSolutions.get(i)+"\t");
            }
            writer.close();
        } catch (Exception e) {}
    }

    @Override
    public void SaveBestSolution()
    {
        BestSolutionCost = Cost;
        for (int j=0 ; j < NoOfVehicles ; j++)
        {
            VehiclesForBestSolution[j].Route.clear();
            if (! Vehicles[j].Route.isEmpty())
            {
                int RoutSize = Vehicles[j].Route.size();
                for (int k = 0; k < RoutSize ; k++) {
                    Node n = Vehicles[j].Route.get(k);
                    VehiclesForBestSolution[j].Route.add(n);
                }
            }
        }
    }

    @Override
    public void SolutionPrint(String Solution_Label)//Print Solution In console
    {
        System.out.println("=========================================================");
        System.out.println(Solution_Label+"\n");

        for (int j=0 ; j < NoOfVehicles ; j++)
        {
            if (! Vehicles[j].Route.isEmpty())
            {   System.out.print("Vehicle " + j + ":");
                int RoutSize = Vehicles[j].Route.size();
                for (int k = 0; k < RoutSize ; k++) {
                    if (k == RoutSize-1)
                    { System.out.print(Vehicles[j].Route.get(k).nodeId );  }
                    else
                    { System.out.print(Vehicles[j].Route.get(k).nodeId+ "->"); }
                }
                System.out.println();
            }
        }
        System.out.println("\nSolution Cost "+this.Cost+"\n");
    }
}




