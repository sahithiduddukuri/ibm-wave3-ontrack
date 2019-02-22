package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Category;
import com.stackroute.recommendationservice.Repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CategoryServiceTest {
    Category category;

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryServiceImpl categoryService;
    List<Category> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        category = new Category();
        category.setId(1);
        category.setProductType("flipflops");
        list = new ArrayList<>();
        list.add(category);
    }

    @Test
    public void saveUserTest()
    {
        when(categoryRepository.save((Category)any())).thenReturn(category);
        Category savedCategory = categoryService.createNode(category);
        Assert.assertEquals(category,savedCategory);
    }

    @Test
    public void getTrackTest() {
        categoryRepository.save(category);
        when(categoryRepository.findAll()).thenReturn(list);
        List<Category> userList = categoryService.getAllCategories();
        Assert.assertEquals(list, userList);
    }
}



