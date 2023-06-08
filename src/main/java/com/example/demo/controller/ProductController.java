package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.payload.request.CreateProductRequest;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.ProductService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public ResponseEntity<List<Product>> getList(){
        List<Product> listProduct = productService.getList();
        listProduct.forEach(product -> Hibernate.initialize(product.getCategory()));

        return ResponseEntity.ok(listProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@ModelAttribute CreateProductRequest req, @RequestParam("file") MultipartFile file) {
        try {
            Product product = productService.createProduct(req, file);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error creating product"));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @ModelAttribute CreateProductRequest request,@RequestParam("file") MultipartFile file){
        try{
             productService.updateProduct(id,request,file);
            return  ResponseEntity.ok(new MessageResponse("Cập nhật thành công"));
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error update product"));
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try{
            productService.deleteById(id);
            return  ResponseEntity.ok(new MessageResponse("Xóa thành công"));
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error delete product"));
        }

    }


}
