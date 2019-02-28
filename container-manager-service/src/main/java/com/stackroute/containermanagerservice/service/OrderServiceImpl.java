package com.stackroute.containermanagerservice.service;

import com.stackroute.containermanagerservice.domain.Order;
import com.stackroute.containermanagerservice.exception.OrderAlreadyExists;
import com.stackroute.containermanagerservice.exception.InvalidOrder;
import com.stackroute.containermanagerservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService
{
    private OrderRepository orderRepository;
    private Order order;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public OrderServiceImpl() {
    }

    @Override
    public Order saveContainer(Order order) throws OrderAlreadyExists
    {
        Optional optional= orderRepository.findById(order.getOrderId());
        if((optional.isPresent()))
        {
            throw new OrderAlreadyExists();
        }
        return orderRepository.insert(order);
    }

    @Override
    public boolean deleteContainer(int orderId) throws InvalidOrder {
        boolean status=false;
        Optional optional= orderRepository.findById(orderId);
        if(optional.isPresent())
        {
            orderRepository.deleteById(orderId);
            status=true;
        }
        else
        {
            throw new InvalidOrder();
        }
        return status;
    }

    @Override
    public Order updateContainer(int orderId, int productId, int productWeight, int productLength, int productWidth, int productBreadth, boolean isFragile, String deliveryLocation, String orderDate, String orderTime) throws InvalidOrder {
        Optional optional= orderRepository.findById(orderId);
        if(optional.isPresent())
        {
            order = orderRepository.findById(orderId).get();
            order.setOrderId(orderId);
            order.setProductId(productId);
            order.setProductWeight(productWeight);
            order.setProductLength(productLength);
            order.setProductWidth(productWidth);
            order.setProductBreadth(productBreadth);
            order.setFragile(isFragile);
            order.setDeliveryLocation(deliveryLocation);
            order.setOrderDate(orderDate);
            order.setOrderTime(orderTime);

        }
        else
        {
            throw new InvalidOrder();
        }
        return order;
    }

    @Override
    public List<Order> getAllContainers() throws Exception {
        return orderRepository.findAll();
    }

//    @Override
//    public Date findAvailableContainer(String date) throws ParseException
//    {
//        Date date1=new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(date);
//        return date1;
//    }
}
