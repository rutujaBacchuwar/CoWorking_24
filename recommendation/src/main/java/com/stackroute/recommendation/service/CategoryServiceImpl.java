package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;


@Service
public class CategoryServiceImpl implements CategoryService {

CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.getNode(categoryName);
    }

    @Override
    public Collection<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Category create(long categoryId, String categoryName, double price, Space space) {
        return categoryRepository.createNode(categoryId,categoryName,price,space);
    }

    @Override
    public Category delete(Long categoryId) {
        return categoryRepository.deleteNode(categoryId);
    }

    @Override
    public Category deleteAll() {
        return categoryRepository.deleteAllNodes();
    }

    @Override
    public Category update(long categoryId, String categoryName, double price) {
        return categoryRepository.updateNode(categoryId,categoryName,price);
    }


}
