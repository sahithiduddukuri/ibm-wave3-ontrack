package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Category;
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
        Category node = categoryRepository.save(category);
        return node;
    }
}
