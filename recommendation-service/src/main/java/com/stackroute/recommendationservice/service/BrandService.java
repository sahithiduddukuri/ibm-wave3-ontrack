package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getAll();
    public Brand createBrandNode(Brand brand);
}
