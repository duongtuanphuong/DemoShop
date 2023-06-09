package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.payload.request.CreateOrderReq;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<?> getListOrder(){
        List<Order> listOrder = orderService.getListOrder();

        return ResponseEntity.ok(listOrder);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderReq req){
        Order order = orderService.createOrder(req);

        return ResponseEntity.ok(order);
    }

}
