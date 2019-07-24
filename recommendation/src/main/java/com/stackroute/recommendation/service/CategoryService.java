package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.domain.Category;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;


@Service
public interface CategoryService {

    public Category findByName(String categoryName);
    public Collection<Category> getAll();
    public Category create(long categoryId, String categoryName, double price, Space space);
    public Category delete(Long categoryId);
    public Category deleteAll();
    public Category update(long categoryId,String categoryName,double price);
}
