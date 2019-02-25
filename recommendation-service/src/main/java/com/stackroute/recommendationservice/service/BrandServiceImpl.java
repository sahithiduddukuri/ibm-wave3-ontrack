package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Brand;
import com.stackroute.recommendationservice.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    BrandRepository brandRepository;

    @Autowired

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAll()
    {
        return (List<Brand>) brandRepository.findAll();
    }

    public Brand createBrandNode(Brand brand) {
        Brand node = brandRepository.save(brand);
        return node;
    }
}
