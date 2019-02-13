package com.stackroute.productService.service;


import com.stackroute.productService.domain.Product;
import com.stackroute.productService.exceptions.ProductAlreadyExistsException;
import com.stackroute.productService.exceptions.ProductAlreadyUpdatedExcetion;
import com.stackroute.productService.exceptions.ProductIdNotFoundException;
import com.stackroute.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class  ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) throws ProductAlreadyExistsException {

        if (productRepository.existsById(product.getProductId())) {
            throw new ProductAlreadyExistsException("Product already exists");
        }
        Product savedProduct = productRepository.save(product);
        if (savedProduct == null) {
            throw new ProductAlreadyExistsException("Product already exist");
        }
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product) throws ProductAlreadyUpdatedExcetion {

        if (productRepository.existsById(product.getProductId())) {
            product.setProductId(product.getProductId());
            product.setProductPrice(product.getProductPrice());
            product.setProductName(product.getProductName());
            return productRepository.save(product);
        } else
            throw new ProductAlreadyUpdatedExcetion("Product doesn't exists.");


    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProduct(String productName) {

        List<Product> products = productRepository.findByproductName(productName);
       // List<Product> productList=  new ArrayList<>();
//        for (Product var : products)
//        {
//            String name = var.getProductName();
//            String regx = "[a-z]*";
//            Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(name);
//            if(matcher.find())
//            {
//                  productList.add(var);
          //  }
      //  }

      //  System.out.println("Product NAME"+ productList);
      //  return productRepository.findByproductName(products);
     // return products;
        return products;
    }


}