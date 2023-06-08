package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.payload.request.CreateProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getList();

    Product findById(long id);

    Product createProduct(CreateProductRequest req, MultipartFile file)  throws IOException;

    void updateProduct(long id,CreateProductRequest req,MultipartFile file) throws IOException;


    void deleteById(long id) throws IOException;


}
