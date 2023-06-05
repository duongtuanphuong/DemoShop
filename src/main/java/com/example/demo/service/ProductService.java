package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.payload.request.CreateProductRequest;

import java.util.List;

public interface ProductService {

    List<Product> getList();

    Product findById(long id);

    Product createProduct(CreateProductRequest req);

    void updateProduct(long id,CreateProductRequest req);


    void deleteById(long id);


}
