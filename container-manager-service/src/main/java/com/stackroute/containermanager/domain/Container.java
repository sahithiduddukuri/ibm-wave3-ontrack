package com.stackroute.containermanager.domain;

import lombok.Data;

@Data
public class Container {

    private String containerId;
    private double availableContainerSize=100;
    private double totalContainerSize;

    public Container(String containerId, double availableContainerSize, double totalContainerSize) {
        this.containerId = containerId;
        this.availableContainerSize = availableContainerSize;
        this.totalContainerSize = totalContainerSize;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public double getAvailableContainerSize() {
        return availableContainerSize;
    }

    public void setAvailableContainerSize(double availableContainerSize) {
        this.availableContainerSize = availableContainerSize;
    }

    public double getTotalContainerSize() {
        return totalContainerSize;
    }

    public void setTotalContainerSize(double totalContainerSize) {
        this.totalContainerSize = totalContainerSize;
    }
}
