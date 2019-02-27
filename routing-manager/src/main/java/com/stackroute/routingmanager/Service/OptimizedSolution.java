package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;

public interface OptimizedSolution {

    public boolean UnassignedCustomerExists(Node[] nodes);
    public void GreedySolution(Node[] nodes , double[][] CostMatrix);
    public void TabuSearch(int TABU_Horizon, double[][] CostMatrix);
    public void SaveBestSolution();
    public void SolutionPrint(String Solution_Label);
}
