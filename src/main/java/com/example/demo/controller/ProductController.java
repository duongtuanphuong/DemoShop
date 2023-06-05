package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.payload.request.CreateProductRequest;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(listProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody CreateProductRequest request){
        Product product = productService.createProduct(request);

        return  ResponseEntity.ok(product);

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody CreateProductRequest request){
        productService.updateProduct(id, request);

        return  ResponseEntity.ok(new MessageResponse("Cập nhật thành công"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        productService.deleteById(id);

        return ResponseEntity.ok(new MessageResponse("Xóa thành công"));

    }


}
