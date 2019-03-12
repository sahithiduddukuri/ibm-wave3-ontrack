package com.stackroute.deliverymanager.Domain;

import lombok.Data;

import java.util.List;


@Data
public class SlotEvaluation
{

    private String slotId;
    private int orderId;
    private List<SlotAvailability> slotAvailabilities;

    private String orderDate;
    //private double containerVolume;

    public SlotEvaluation(String slotId, List<SlotAvailability> slotAvailabilities)
    {
        this.slotId = slotId;
        this.slotAvailabilities = slotAvailabilities;
    }

    public SlotEvaluation() {
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public List<SlotAvailability> getSlotAvailabilities() {
        return slotAvailabilities;
    }

    public void setSlotAvailabilities(List<SlotAvailability> slotAvailabilities) {
        this.slotAvailabilities = slotAvailabilities;
    }

    @Override
    public String toString()
    {
        return "SlotEvaluation{" +
                "slotId='" + slotId + '\'' +
                ", slotAvailabilities=" + slotAvailabilities +
                '}';
    }
}
