package com.DB.exam.service;

import com.DB.exam.dto.OrderDTO;
import com.DB.exam.model.Order;
import com.DB.exam.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void create(OrderDTO orderDTO){
        Order newOrder = new Order();
        newOrder.setTimestamp(orderDTO.getTimestamp());

        orderRepository.save(newOrder);
    }

    public void saveNewOrder(Order order){
        orderRepository.save(order);
    }
}
