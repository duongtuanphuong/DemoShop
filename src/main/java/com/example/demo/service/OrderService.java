package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;
import com.example.demo.payload.request.CreateOrderReq;

public interface OrderService {
    
    List<Order> getListOrder();

    Order createOrder(CreateOrderReq req);
}
