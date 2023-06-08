package com.example.demo.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateProductRequest {
    private String name;

    private String description;

    private long price;

    private int quantity;

//    private MultipartFile thumbnail;

    private long categoryId;
}
