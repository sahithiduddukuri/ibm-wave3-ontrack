package com.stackroute.containermanagerservice.service;

import com.stackroute.containermanagerservice.domain.Container;
import com.stackroute.containermanagerservice.exception.ContainerAlreadyFull;
import com.stackroute.containermanagerservice.exception.ContainerNotFound;
import com.stackroute.containermanagerservice.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContainerServiceImpl implements ContainerService
{
    private ContainerRepository containerRepository;
    private Container container;

    @Autowired
    public ContainerServiceImpl(ContainerRepository containerRepository)
    {
        this.containerRepository = containerRepository;
    }

    public ContainerServiceImpl() {
    }

    @Override
    public Container saveContainer(Container container) throws ContainerAlreadyFull
    {
        Optional optional=containerRepository.findById(container.getOrderId());
        if((optional.isPresent()))
        {
            throw new ContainerAlreadyFull();
        }
        return containerRepository.insert(container);
    }

    @Override
    public boolean deleteContainer(int orderId) throws ContainerNotFound {
        boolean status=false;
        Optional optional=containerRepository.findById(orderId);
        if(optional.isPresent())
        {
            containerRepository.deleteById(orderId);
            status=true;
        }
        else
        {
            throw new ContainerNotFound();
        }
        return status;
    }

    @Override
    public Container updateContainer(int orderId,int productId, int productWeight, int productLength, int productWidth, int productBreadth, boolean isFragile, String deliveryLocation,String orderDate,String orderTime,String containerId,String date,String slotNumber) throws ContainerNotFound {
        Optional optional=containerRepository.findById(orderId);
        if(optional.isPresent())
        {
            container=containerRepository.findById(orderId).get();
            container.setOrderId(orderId);
            container.setProductId(productId);
            container.setProductWeight(productWeight);
            container.setProductLength(productLength);
            container.setProductWidth(productWidth);
            container.setProductBreadth(productBreadth);
            container.setFragile(isFragile);
            container.setDeliveryLocation(deliveryLocation);
            container.setOrderDate(orderDate);
            container.setOrderTime(orderTime);
            container.setConatinerId(containerId);
            container.setDate(date);
            container.setSlotNumber(slotNumber);
        }
        else
        {
            throw new ContainerNotFound();
        }
        return container;
    }

    @Override
    public List<Container> getAllContainers() throws Exception {
        return containerRepository.findAll();
    }

    @Override
    public Date findAvailableContainer(String date) throws ParseException
    {
        Date date1=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(date);
        return date1;
    }
}
