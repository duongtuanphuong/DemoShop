package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.payload.request.CreateOrderItemRequest;
import com.example.demo.payload.request.CreateOrderReq;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<Order> getListOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(CreateOrderReq req) {
        Order order = new Order();
        order.setName(req.getName());
        order.setEmail(req.getEmail());
        order.setPhone(req.getPhone());
        Set<OrderItem> orderItems = new HashSet<>();
        for(CreateOrderItemRequest rq : req.getOrderItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setName(rq.getName());
            orderItem.setPrice(rq.getPrice());
            orderItem.setQuantity(rq.getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        orderItemRepository.saveAll(orderItems);
        orderRepository.save(order);
        
        return order;
    }
    
}
