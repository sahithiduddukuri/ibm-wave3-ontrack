package com.stackroute.containermanager.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import java.sql.DataTruncation;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Document
@Data
public class SlotEvaluation
{

    private String slotId;
    private int orderId;
    private List<SlotAvailability> slotAvailabilities;
    @Id
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
