package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.payload.request.CreateCategoryReq;

import java.util.List;

public interface CategoryService {

    List<Category> getListCategory();

    Category findCategoryByID(long id);

    Category createCategory(CreateCategoryReq req);

    void updateCategory(long id, CreateCategoryReq req);

    void deleteCategory(long id);
}
