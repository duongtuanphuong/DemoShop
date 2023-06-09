package com.example.demo.payload.request;

import lombok.Data;

@Data
public class CreateOrderItemRequest {
    
    private String name;

    private long price;

    private int quantity;

}
