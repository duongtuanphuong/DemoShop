package com.example.demo.payload.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;

    private String description;

    private long price;

    private int quantity;

    private String thumbnail;

    private long categoryId;
}
