package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.payload.request.CreateCategoryReq;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryByID(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }

    @Override
    public Category createCategory(CreateCategoryReq req) {
        Category category = new Category();
        category.setName(req.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(long id, CreateCategoryReq req) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            Category rs = category.get();
            rs.setName(req.getName());
            categoryRepository.save(rs);
        }
    }

    @Override
    public void deleteCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            Category rs = category.get();
            categoryRepository.delete(rs);
        }
    }
}
