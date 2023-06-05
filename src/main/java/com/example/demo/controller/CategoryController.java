package com.example.demo.controller;


import com.example.demo.entity.Category;
import com.example.demo.payload.request.CreateCategoryReq;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<Category> categories = categoryService.getListCategory();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable long id){
        Category category = categoryService.findCategoryByID(id);
        return ResponseEntity.ok(category);
    }
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryReq req){
        Category category = categoryService.createCategory(req);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable long id,@RequestBody CreateCategoryReq req){
        categoryService.updateCategory(id,req);
        return ResponseEntity.ok(new MessageResponse("Cập nhật thành công"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new MessageResponse("Xóa thành công"));
    }}
