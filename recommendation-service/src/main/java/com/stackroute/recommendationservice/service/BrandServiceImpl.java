package com.stackroute.recommendationservice.service;

import com.stackroute.rabbitmq.domain.Brand;
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

    @Override
    public List<Brand> getAll()
    {
        return (List<Brand>) brandRepository.getAllBrands();
    }

    public List<Brand> getAllBrand()
    {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public Brand createBrandNode(Brand brands) {
        String brandId = brands.getBrandId();
        String brand = brands.getBrand();
        Brand node = brandRepository.createBrand(brandId,brand);
        return node;
    }
}
