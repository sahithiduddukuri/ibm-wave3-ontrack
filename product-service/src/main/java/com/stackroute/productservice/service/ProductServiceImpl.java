package com.stackroute.productservice.service;

import com.stackroute.productservice.domain.Products;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import com.stackroute.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Products saveProduct(Products products) throws ProductAlreadyExistsException {

         if(productRepository.existsById(products.getProductId())){
             throw new ProductAlreadyExistsException("Products already exists");
         }
        Products savedProducts = productRepository.save(products);
         if(savedProducts ==null){
             throw new ProductAlreadyExistsException("Products already exist");
         }
        return savedProducts;
    }
    @Override
    public Products updateProduct(Products products) throws ProductAlreadyUpdatedException {

       if(productRepository.existsById(products.getProductId())){


           throw new ProductAlreadyUpdatedException("Products doesn't exists.");
       }else


                  products.setProductId(products.getProductId());
                 products.setProductName(products.getProductName());
                   products.setProductType(products.getProductType());
        products.setImageURL(products.getMrp());
        products.setMrp(products.getMrp());
        products.setPrice(products.getPrice());
        products.setDimension(products.getDimension());
        products.setWeight(products.getWeight());
        products.setSize(products.getSize());
        products.setGender(products.getGender());
        products.setDescription(products.getDescription());
        products.setBrand(products.getBrand());
        products.setColour(products.getColour());
        return productRepository.save(products);


    }


    @Override
    public boolean deleteProduct(String id) throws ProductIdNotFoundException {
            boolean status=false;
           if(productRepository.existsById(id)){

               productRepository.deleteById(id);

               status=true;
               return status;
           }
           else{
               throw new ProductIdNotFoundException("Products id not found");
           }



    }


    @Override
    public List<Products> getAllProducts()
    {
        return productRepository.findAll();
    }


}
