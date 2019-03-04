package com.stackroute.recommendationservice.service;

import com.stackroute.domain.Category;
import com.stackroute.recommendationservice.Repository.CategoryRepository;
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

    public List<Category> getAllCategories()
    {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category createNode(Category category) {
        String productTypeId = category.getProductTypeId();
        String productType = category.getProductType();
        Category node = categoryRepository.createCategoryNode(productTypeId,productType);
        return node;
    }
}
