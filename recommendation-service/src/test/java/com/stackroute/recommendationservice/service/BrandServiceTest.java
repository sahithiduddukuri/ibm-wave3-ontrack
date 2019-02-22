package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Brand;
import com.stackroute.recommendationservice.Repository.BrandRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BrandServiceTest {
    Brand brand;

    @Mock
    BrandRepository brandRepository;

    @InjectMocks
    BrandServiceImpl brandService;
    List<Brand> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        brand = new Brand();
        brand.setId(1);
        brand.setBradName("lavie");
        list = new ArrayList<>();
        list.add(brand);
    }

    @Test
    public void saveBrandTest()
    {
        when(brandRepository.save((Brand)any())).thenReturn(brand);
        Brand savedBrand = brandService.createBrandNode(brand);
        Assert.assertEquals(brand,savedBrand);
    }

    @Test
    public void getTrackTest() {
        brandRepository.save(brand);
        when(brandRepository.findAll()).thenReturn(list);
        List<Brand> userList = brandService.getAll();
        Assert.assertEquals(list, userList);
    }
}





