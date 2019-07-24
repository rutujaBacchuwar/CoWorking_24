package com.stackroute.workspaceService.service;

import com.stackroute.workspaceService.domain.MyCategory;
import com.stackroute.workspaceService.exception.CategoryAlreadyExists;
import com.stackroute.workspaceService.exception.CategoryNotFoundException;
import com.stackroute.workspaceService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<MyCategory> getAllCategories() {
        return categoryRepository.findAll();

    }

    @Override
    public MyCategory saveCategory(MyCategory mycategory) throws CategoryAlreadyExists {
        if (categoryRepository.existsByCategoryId(mycategory.getCategoryId()))
            throw new CategoryAlreadyExists("category Already Exists");
        MyCategory savedCategory = categoryRepository.save(mycategory);
        return savedCategory;
    }


    @Override
    public boolean deleteCategory(MyCategory mycategory) throws Exception {
        if (categoryRepository.existsByCategoryId(mycategory.getCategoryId())) {
            categoryRepository.deleteByCategoryId(mycategory.getCategoryId());
            return true;
        } else {
            throw new Exception("Exception in delete Category");
        }
    }


    @Override
    public MyCategory updateCategory(MyCategory mycategory) throws CategoryNotFoundException {
        if (categoryRepository.existsByCategoryId(mycategory.getCategoryId())) {
            MyCategory saveCategory = categoryRepository.save(mycategory);
            return saveCategory;
        } else {
            throw new CategoryNotFoundException("Category not found");
        }
    }

    @Override
    public List<MyCategory> findByCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}

