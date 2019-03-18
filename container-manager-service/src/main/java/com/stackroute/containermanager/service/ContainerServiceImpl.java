package com.stackroute.containermanager.service;
import com.stackroute.containermanager.domain.*;
import com.stackroute.containermanager.exception.OrderAlreadyExists;
import com.stackroute.containermanager.exception.OrderNotFound;
import com.stackroute.containermanager.repository.ContainerRepository;
import com.stackroute.containermanager.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
@Service
public class ContainerServiceImpl implements ContainerService {
    private ContainerRepository containerRepository;
    private SlotRepository slotRepository;
    @Autowired
    public ContainerServiceImpl(ContainerRepository containerRepository, SlotRepository slotRepository) {
        this.containerRepository = containerRepository;
        this.slotRepository = slotRepository;
    }
    @Override
    public SlotEvaluation saveOrderAndGetSlots(Order order) throws OrderAlreadyExists {
//        if (containerRepository.existsById(order.getOrderDate())) {
//            throw new OrderAlreadyExists("Order already exists");
//        }
        Order savedOrder = containerRepository.save(order);
//        if (savedOrder == null) {
//            throw new OrderAlreadyExists();
//        }
        return getSlot(order);
//        return savedOrder;
        // getSlots();
    }
    public SlotEvaluation getSlot(Order order) {
        if (slotRepository.existsById(order.getOrderDate())) {
            Optional<SlotEvaluation> slotEvaluation = slotRepository.findById(order.getOrderDate());
            List<SlotAvailability> slotAvailabilities = slotEvaluation.get().getSlotAvailabilities();
            for (SlotAvailability slotAvailability : slotAvailabilities) {
                String slotDate = slotAvailability.getDate();
                List<Slot> slots = slotAvailability.getSlots();
                for (Slot slot : slots) {
                    slot.getSlotType();
                    slot.getAvailableContainer();
                    List<Container> containers= slot.getContainers();
                    if(containers.get(0).getAvailableContainerSize()>= order.getProductCount()*20)
                    {
                        if (order.getProductCount()* 20 == 100) {
                            slot.setCost(10);
                        } else if (order.getProductCount()* 20 == 80) {
                            slot.setCost(20);
                        } else if (order.getProductCount() * 20 == 60) {
                            slot.setCost(40);
                        } else if (order.getProductCount() * 20 == 40) {
                            slot.setCost(60);
                        } else if (order.getProductCount() * 20 == 20) {
                            slot.setCost(80);
                        }
                        slot.setSlotStatus(true);
                    }
                    else if(containers.get(1).getAvailableContainerSize()>= order.getProductCount()*20)
                    {
                        if (order.getProductCount()* 20 == 100) {
                            slot.setCost(10);
                        } else if (order.getProductCount() * 20 == 80) {
                            slot.setCost(20);
                        } else if (order.getProductCount()* 20 == 60) {
                            slot.setCost(40);
                        } else if (order.getProductCount() * 20 == 40) {
                            slot.setCost(60);
                        } else if (order.getProductCount() * 20 == 20) {
                            slot.setCost(80);
                        }
                        slot.setSlotStatus(true);
                    }
                    else {
                        slot.setSlotStatus(false);
                    }

                }
                slotAvailability.setSlots(slots);
                slotEvaluation.get().setSlotAvailabilities(slotAvailabilities);
            }
            return slotRepository.save(slotEvaluation.get());
        } else {
            SlotEvaluation slotEvaluation = new SlotEvaluation();
            slotEvaluation.setOrderId(order.getOrderId());
            slotEvaluation.setOrderDate(order.getOrderDate());
            List<SlotAvailability> slotAvailabilities = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                SlotAvailability slotAvailability = new SlotAvailability();
                if (i == 0) {
                    slotAvailability.setDate(order.getOrderDate());
                    slotAvailabilities.add(slotAvailability);
                    List<Slot> slots = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        Slot slot = new Slot();
                        if (j == 0) {
                            String slotType = "A";
                            slot.setSlotStatus(false);
                            slot.setCost(10);
                            slot.setSlotType("A");
                            List<Container> containers=new ArrayList<>();
                            Container container = new Container("1",100,100);
                            Container container1 =new Container("2",100,100);
                            containers.add(container);
                            containers.add(container1);
                            slot.setContainers(containers);
                            slot.setAvailableContainerSize(100);
                            slots.add(slot);
                        }
                        if (j == 1) {
                            String slotType = "B";
                            slot.setSlotStatus(true);
                            slot.setCost(10);
                            slot.setSlotType("B");
                            List<Container> containers=new ArrayList<>();
                            Container container = new Container("1",100,100);
                            Container container1 =new Container("2",100,100);
                            containers.add(container);
                            containers.add(container1);
                            slot.setContainers(containers);
                            slot.setAvailableContainerSize(100);
                            slots.add(slot);
                        }
                        if (j == 2) {
                            String slotType = "C";
                            slot.setSlotStatus(true);
                            slot.setCost(10);
                            slot.setSlotType("C");
                            List<Container> containers=new ArrayList<>();
                            Container container = new Container("1",100,100);
                            Container container1 =new Container("2",100,100);
                            containers.add(container);
                            containers.add(container1);
                            slot.setContainers(containers);
                            slot.setAvailableContainerSize(100);
                            slots.add(slot);
                        }
                    }
                    slotAvailability.setSlots(slots);
                    slotEvaluation.setSlotAvailabilities(slotAvailabilities);
                }
                if (i == 1) {
//                    slotAvailability.setDate(order.getOrderDate().plusDays(1));
                    slotAvailability.setDate(getNextDate(order.getOrderDate()));
                    slotAvailabilities.add(slotAvailability);
                    List<Slot> slots = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        Slot slot = new Slot();
                        if (j == 0) {
                            String slotType = "A";
                            slot.setSlotStatus(true);
                            slot.setCost(5);
                            slot.setSlotType("A");
                            List<Container> containers=new ArrayList<>();
                            Container container = new Container("1",100,100);
                            Container container1 =new Container("2",100,100);
                            containers.add(container);
                            containers.add(container1);
                            slot.setContainers(containers);
                            slot.setAvailableContainerSize(100);
                            slots.add(slot);
                        }
                        if (j == 1) {
                            String slotType = "B";
                            slot.setSlotStatus(true);
                            slot.setCost(5);
                            slot.setSlotType("B");
                            List<Container> containers=new ArrayList<>();
                            Container container = new Container("1",100,100);
                            Container container1 =new Container("2",100,100);
                            containers.add(container);
                            containers.add(container1);
                            slot.setContainers(containers);
                            slot.setAvailableContainerSize(100);
                            slots.add(slot);
                        }
                        if (j == 2) {
                            String slotType = "C";
                            slot.setSlotStatus(true);
                            slot.setCost(5);
                            slot.setSlotType("C");
                            List<Container> containers=new ArrayList<>();
                            Container container = new Container("1",100,100);
                            Container container1 =new Container("2",100,100);
                            containers.add(container);
                            containers.add(container1);
                            slot.setContainers(containers);
                            slot.setAvailableContainerSize(100);
                            slots.add(slot);
                        }
                    }
                    slotAvailability.setSlots(slots);
                }
                slotEvaluation.setSlotAvailabilities(slotAvailabilities);
            }
            return slotRepository.save(slotEvaluation);
        }
    }
    public SlotEvaluation saveSelecteSlots(SelectedSlot selectedSlot) throws OrderNotFound, OrderAlreadyExists {
        if (slotRepository.existsById(selectedSlot.getOrderDate())) {
            System.out.println("inside if");
            Optional<SlotEvaluation> slotEvaluation = slotRepository.findById(selectedSlot.getOrderDate());
            List<SlotAvailability> slotAvailabilities = slotEvaluation.get().getSlotAvailabilities();
            System.out.println("slotavailabiloity data+++++++++++++++++++++" + slotAvailabilities);
            for (SlotAvailability slotAvailability : slotAvailabilities) {
                String slotDate = slotAvailability.getDate();
//                List<Slot> slots = slotAvailability.getSlots();
                if (slotDate.equals(slotAvailability.getDate())) {
                    List<Slot> slots = slotAvailability.getSlots();
                    for (Slot slot : slots) {
                        if (selectedSlot.getSlotType().equals(slot.getSlotType())) {
                            int selectedWeight = selectedSlot.getProductCount()* 20;
                            List<Container> containers= slot.getContainers();
                            if(containers.get(0).getAvailableContainerSize()>selectedWeight)
                            {
                                System.out.println("this is inside if of index 0#######$$$$$$$$$$########");
                                containers.get(0).setAvailableContainerSize(containers.get(0).getAvailableContainerSize()-selectedWeight);
                            }
                            else {
                                if(containers.get(1).getAvailableContainerSize()>selectedWeight)
                                    containers.get(1).setAvailableContainerSize(containers.get(1).getAvailableContainerSize()-selectedWeight);
                                else
                                    slot.setSlotStatus(false);
                            }
//                            slot.setAvailableContainerSize(slot.getAvailableContainerSize() - selectedWeight);
                        }
                    }
                }
                return slotRepository.save(slotEvaluation.get());
            }
        }
        return null;
    }

    @Override
    public SlotEvaluation getSlotByDate(String date) throws OrderNotFound {
//        return null;
        if(slotRepository.existsById(date))
        {
            return slotRepository.findById(date).get();
        }
        else{
            return null;
        }
    }

    public static String getNextDate(String  curDate) {
        String nextDate="";

        try {
            LocalDate date = LocalDate.now();
            date = date.plusDays(1);
            nextDate = date.toString();
        } finally {
            return nextDate;
        }
    }
}
