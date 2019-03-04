package com.stackroute.containermanager.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SlotAvailability
{
    private String date;
    private List<Slot> slots;

    public SlotAvailability(String date, List<Slot> slots)
    {
        this.date = date;
        this.slots = slots;
    }

    public SlotAvailability() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "SlotAvailability{" +
                "date=" + date +
                ", slots=" + slots +
                '}';
    }
}
