package com.stackroute.containermanager.domain;

import lombok.Data;

import java.util.List;

@Data
public class Slot
{
    private boolean slotStatus;
    private String slotType;
    private double cost;
    private double availableContainer;
    private int availableContainerSize = 100;
    private List<Container> containers;

    public Slot() {
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
