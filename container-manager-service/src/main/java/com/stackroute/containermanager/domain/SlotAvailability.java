package com.stackroute.containermanager.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SlotAvailability
{
    private LocalDate date;
    private List<Slot> slots;

    public SlotAvailability(LocalDate date, List<Slot> slots)
    {
        this.date = date;
        this.slots = slots;
    }

    public SlotAvailability() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
