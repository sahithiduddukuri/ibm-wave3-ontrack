package com.stackroute.productservice.batch;

import com.stackroute.productservice.domain.Products;
import com.stackroute.productservice.repository.ProductRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DBWriter implements ItemWriter<Products> {

    @Autowired
    private ProductRepository productRepository;



    @Override
    public void write(List<? extends Products> products) throws Exception {
        System.out.println("Data Saved for Products: " + products);
        productRepository.saveAll(products);

    }
}
