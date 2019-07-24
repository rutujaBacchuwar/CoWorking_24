package com.stackroute.workspaceService.service;



import com.stackroute.workspaceService.domain.MyCategory;
import com.stackroute.workspaceService.exception.CategoryAlreadyExists;
import com.stackroute.workspaceService.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {
    public List<MyCategory> getAllCategories();
    public MyCategory saveCategory(MyCategory mycategory) throws CategoryAlreadyExists;
    public boolean deleteCategory(MyCategory mycategory) throws Exception;
    public MyCategory updateCategory(MyCategory mycategory) throws CategoryNotFoundException;
    public List<MyCategory> findByCategory(String categoryName);
}
