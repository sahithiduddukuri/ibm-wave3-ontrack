package com.stackroute.containermanagerservice.domain;

import lombok.Data;

@Data
public class FindSlots
{
    private String slotAvailable;
    private boolean slotStatus;
    private int slotProfit;

    public FindSlots(String slotAvailable, boolean slotStatus, int slotProfit)
    {
        this.slotAvailable = slotAvailable;
        this.slotStatus = slotStatus;
        this.slotProfit = slotProfit;
    }

    public String getSlotAvailable() {
        return slotAvailable;
    }

    public void setSlotAvailable(String slotAvailable) {
        this.slotAvailable = slotAvailable;
    }

    public boolean isSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(boolean slotStatus) {
        this.slotStatus = slotStatus;
    }

    public int getSlotProfit() {
        return slotProfit;
    }

    public void setSlotProfit(int slotProfit) {
        this.slotProfit = slotProfit;
    }
}
