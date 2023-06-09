package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.payload.request.CreateProductRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ImageService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {




    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        Optional<Product> rs = productRepository.findById(id);

        return rs.get();
    }

    @Override
    public Product createProduct(CreateProductRequest req,MultipartFile file) throws IOException {
        Product product = new Product();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setQuantity(req.getQuantity());

       if(file != null){
           String thumbnailPath = imageService.uploadImage(file);
           product.setThumbnail(thumbnailPath);
       }

        Optional<Category> category = categoryRepository.findById(req.getCategoryId());
        if(category.isPresent()){
            product.setCategory(category.get());
        }
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(long id, CreateProductRequest req,MultipartFile file) throws IOException {
        Optional<Product> rs = productRepository.findById(id);
        if(rs.isPresent()){
            Product product = rs.get();
            product.setName(req.getName());
            product.setDescription(req.getDescription());
            product.setPrice(req.getPrice());
            product.setQuantity(req.getQuantity());

            if (file != null) {
                // imageService.deleteImage(product.getThumbnail());

                String thumbnailPath = imageService.uploadImage(file);
                product.setThumbnail(thumbnailPath);
            }

            Optional<Category> category = categoryRepository.findById(req.getCategoryId());
            if(category.isPresent()){
                product.setCategory(category.get());
            }
            productRepository.save(product);
        }
    }

    @Override
    public void deleteById(long id) throws IOException {
        Optional<Product> rs = productRepository.findById(id);
        if(rs.isPresent()){
            Product product = rs.get();
            // imageService.deleteImage(product.getThumbnail());
            productRepository.delete(product);
        }
    }
}
