package com.stackroute;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ContainerManager
{
    static Scanner sc = new Scanner(System.in);

    private int numberOfContainers;
    private int numberOfUsers;
    private int numberOfProducts;
    private int containerVolume;
    private int boxVolume;
    private int totalVolume;
    private int remainingSpace;
    private int containerCapacity;
    private int availability;
    private String orderDate;
    private String orderTime;
    private Calendar calendar;

    public void findSuitableContainer() throws ParseException {
        int containers[]={0,0,0};
        containerVolume=100;
        boxVolume=20;
        numberOfUsers = 1;
        System.out.println("Maximum number of orders by the user:");
        numberOfProducts=sc.nextInt();
        int products[]=new int[numberOfProducts];
        System.out.println("Enter the number of products ordered by the user at different time slots:");
        for(int i=0;i<products.length;i++)
        {
            products[i]=sc.nextInt();
        }
        //System.out.println("Enter the date of each order:");
//        for(int i=0;i<numberOfProducts;i++) {
//            orderDate = sc.nextLine();
//        }
//        System.out.println("Enter the time of each order:");
//        for(int i=0;i<numberOfProducts;i++) {
//            orderTime = sc.nextLine();
//        }
        int lastProduct=products[products.length-1];
        containerCapacity=containerVolume/boxVolume;
        int remaining = 0;
        System.out.println("Updated containers:");
        int j=0;
        for (int i=0;i<containers.length;i++)
        {
            availability=containerCapacity-containers[i];
            System.out.println(availability + "This is availblity " + i);
            if(availability>=products[j])
            {
                containers[i]=products[j];
                j++;
//                if(j==products.length)
//                {
//                    break;
//                }
            }
            else if(availability<products[j])
            {

                    remaining = products[j] - availability;
                    containers[i] = availability;
                    i++;
                    containers[i] = remaining;
                    j++;
//                    if(j==products.length)
//                {
//                    break;
//                }
            }
//            else if(lastProduct<3)
//            {
//                if(containers[i])
//            }
        }
        for (int i=0;i<containers.length;i++)
        {
            System.out.print("\t"+containers[i]);
        }
    }

//    public void findTimeSlot() throws ParseException
//    {
//        Calendar calendar1=Calendar.getInstance();
//        String slot1start="24/02/2019 09:00 AM";
//        Date time1=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot1start);
//        calendar1.setTime(time1);
//        //System.out.println(time1.getTime());
//
//        Calendar calendar2=Calendar.getInstance();
//        String slot1end="24/02/2019 12:00 PM";
//        Date time2=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot1end);
//        calendar2.setTime(time2);
//        calendar2.add(Calendar.DATE,1);
//
//
//        Calendar calendar3=Calendar.getInstance();
//        String slot2start="24/02/2019 01:00 PM";
//        Date time3=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot2start);
//        calendar3.setTime(time3);
//        calendar3.add(Calendar.DATE,1);
//
//        Calendar calendar4=Calendar.getInstance();
//        String slot2end="24/02/2019 04:00 PM";
//        Date time4=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot2end);
//        calendar4.setTime(time4);
//        calendar4.add(Calendar.DATE,1);
//
//        Calendar calendar5=Calendar.getInstance();
//        String slot3start="24/02/2019 05:00 PM";
//        Date time5=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot3start);
//        calendar5.setTime(time5);
//        calendar5.add(Calendar.DATE,1);
//
//        Calendar calendar6=Calendar.getInstance();
//        String slot3end="24/02/2019 08:00 PM";
//        Date time6=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot3end);
//        calendar6.setTime(time6);
//        calendar6.add(Calendar.DATE,1);
//
//        // ----------------------------------------------------------------------------------
//
//        Calendar calendar11=Calendar.getInstance();
//        String slot11start="25/02/2019 09:00 AM";
//        Date time11=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot11start);
//        calendar11.setTime(time11);
//
//        Calendar calendar22=Calendar.getInstance();
//        String slot11end="25/02/2019 12:00 PM";
//        Date time22=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot11end);
//        calendar22.setTime(time22);
//        calendar22.add(Calendar.DATE,1);
//
//        Calendar calendar33=Calendar.getInstance();
//        String slot22start="25/02/2019 01:00 PM";
//        Date time33=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot22start);
//        calendar33.setTime(time33);
//        calendar33.add(Calendar.DATE,1);
//
//        Calendar calendar44=Calendar.getInstance();
//        String slot22end="25/02/2019 04:00 PM";
//        Date time44=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot22end);
//        calendar44.setTime(time44);
//        calendar44.add(Calendar.DATE,1);
//
//        Calendar calendar55=Calendar.getInstance();
//        String slot33start="25/02/2019 05:00 PM";
//        Date time55=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot33start);
//        calendar55.setTime(time55);
//        calendar55.add(Calendar.DATE,1);
//
//        Calendar calendar66=Calendar.getInstance();
//        String slot33end="25/02/2019 08:00 PM";
//        Date time66=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(slot3end);
//        calendar66.setTime(time66);
//        calendar66.add(Calendar.DATE,1);
//
//        //System.out.println("The orderdetails are:");
//        String orderTime=null;
//        Date dateTime = new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(orderTime);
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(dateTime);
//        calendar.add(Calendar.DATE, 1);
//        Date myDate=calendar.getTime();
//
//        if(myDate.after(calendar1.getTime()) && myDate.before(calendar2.getTime()))
//        {
//            System.out.println("Day-1 morning slot not available");
//            findSuitableContainer();
//            System.out.println("\n Available time slots are: \n"+"Day-1 slot:2--> "+slot2start+" --> "+slot2end+" | Day-1 slot:3--> "+slot3start+" --> "+slot3end
//            +" | Day-2 slot:1--> "+slot11start+" --> "+slot11end+" | Day-2 slot:2--> "+slot22start+" --> "+slot22end+" | Day-2 slot:3--> "+slot33start+" --> "+slot33end);
//        }
//        else if(myDate.after(calendar3.getTime()) && myDate.before(calendar4.getTime()))
//        {
//            System.out.println("Day-1 noon slot not available");
//            findSuitableContainer();
//            System.out.println("\n Available time slots are: \n"+"Day-1 slot:1--> "+slot1start+" --> "+slot1end+" | Day-1 slot:3--> "+slot3start+" --> "+slot3end
//                    +" | Day-2 slot:1--> "+slot11start+" --> "+slot11end+" | Day-2 slot:2--> "+slot22start+" --> "+slot22end+" | Day-2 slot:3--> "+slot33start+" --> "+slot33end);
//        }
//        else if(myDate.after(calendar5.getTime()) && myDate.before(calendar6.getTime()))
//        {
//            System.out.println("Day-1 evening slot not available");
//            findSuitableContainer();
//            System.out.println("\n Available time slots are: \n"+"Day-1 slot:1--> "+slot1start+" --> "+slot1end+" | Day-1 slot:2--> "+slot2start+" --> "+slot2end
//                    +" | Day-2 slot:1--> "+slot11start+" --> "+slot11end+" | Day-2 slot:2--> "+slot22start+" --> "+slot22end+" | Day-2 slot:3--> "+slot33start+" --> "+slot33end);
//        }
//        else if(myDate.after(calendar11.getTime()) && myDate.before(calendar22.getTime()))
//        {
//            System.out.println("Day-2 morning slot not available");
//            findSuitableContainer();
//            System.out.println("\n Available time slots are: \n" +" | Day-2 slot:2--> "+slot22start+" --> "+slot22end+" | Day-2 slot:3--> "+slot33start+" --> "+slot33end);
//        }
//        else if(myDate.after(calendar33.getTime()) && myDate.before(calendar44.getTime()))
//        {
//            System.out.println("Day-2 noon slot not available");
//            findSuitableContainer();
//            System.out.println("\n Available time slots are: \n"+" | Day-2 slot:1--> "+slot11start+" --> "+slot11end+" | Day-2 slot:3--> "+slot33start+" --> "+slot33end);
//        }
//        else if(myDate.after(calendar55.getTime()) && myDate.before(calendar66.getTime()))
//        {
//            System.out.println("Day-2 evening slot not available");
//            findSuitableContainer();
//            System.out.println("\n Available time slots are: \n" +" | Day-2 slot:1--> "+slot11start+" --> "+slot11end+" | Day-2 slot:3--> "+slot33start+" --> "+slot33end);
//        }
//        else
//        {
//            System.out.println("No available slots");
//        }
//    }

    public static void main(String[] args) throws ParseException {
        ContainerManager containerManager = new ContainerManager();
        containerManager.findSuitableContainer();
        //containerManager.findTimeSlot();
    }
}
