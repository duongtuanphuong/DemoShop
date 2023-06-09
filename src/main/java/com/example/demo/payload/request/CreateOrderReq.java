package com.example.demo.payload.request;

import java.util.Set;

import lombok.Data;

@Data
public class CreateOrderReq {
  
    private String name;

    private String email;

    private String phone;

    private Set<CreateOrderItemRequest> orderItems;
}
