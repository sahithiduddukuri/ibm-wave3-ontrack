package com.stackroute.containermanager.domain;

import java.util.List;

public class Slot
{
    private boolean slotStatus;
    private String slotType;
    private double cost;
    private double availableContainer;

    public Slot(boolean slotStatus, String slotType, double cost, double availableContainer)
    {
        this.slotStatus = slotStatus;
        this.slotType = slotType;
        this.cost = cost;
        this.availableContainer = availableContainer;
    }

    public Slot() {
    }

    public boolean isSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(boolean slotStatus) {
        this.slotStatus = slotStatus;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAvailableContainer() {
        return availableContainer;
    }

    public void setAvailableContainer(double availableContainer) {
        this.availableContainer = availableContainer;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotStatus=" + slotStatus +
                ", slotType='" + slotType + '\'' +
                ", cost=" + cost +
                ", availableContainer=" + availableContainer +
                '}';
    }
}
