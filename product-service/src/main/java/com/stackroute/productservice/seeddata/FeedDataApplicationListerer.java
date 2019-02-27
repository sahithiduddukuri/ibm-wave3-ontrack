package com.stackroute.productservice.seeddata;

import com.opencsv.CSVReaderBuilder;
import com.stackroute.productservice.domain.Products;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;

@Component
public class FeedDataApplicationListerer implements ApplicationListener <ContextRefreshedEvent> {

    private ProductService productService;
    private Products products;

    @Autowired
    public FeedDataApplicationListerer(ProductService productService) throws ProductAlreadyExistsException {
       this.productService=productService;

        this.products = new Products();
        this.products.setProductId("111");
        this.products.setProductName("Nike shoe");
        this.products.setProductType("sports shoe");
        this.products.setProductTypeId("101");
        this.products.setImageURL("");
        this.products.setMrp("2000");
        this.products.setPrice("1499");
        this.products.setDimension("14*10*5");
        this.products.setWeight("780gm");
        this.products.setSize("6,7,8,9,10");
        this.products.setGender("Men");
        this.products.setDescription("nike men shoe");
        this.products.setBrand("Nike");
        this.products.setBrandId("112");
        this.products.setColour("Green");


       productService.saveProduct(products);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {

        File file = new File("./assets/ProductSeeddataSheet.csv");
        System.out.println("File Exists : " + file.exists());

       try{
        FileReader filereader = new FileReader(file);

        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();
        List<String[]> allData = csvReader.readAll();

           System.out.println("ohsad"+allData.size());


        for (String[] row : allData) {

            System.out.println("values"+Arrays.toString(row));

                products.setProductId(row[0]);
                products.setProductName(row[1]);
                products.setProductType(row[2]);
                products.setProductTypeId(row[3]);
                products.setImageURL(row[4]);
                products.setMrp(row[5]);
                products.setPrice(row[6]);
                products.setDimension(row[7]);
                products.setWeight(row[8]);
                products.setSize(row[9]);
                products.setGender(row[10]);
                products.setDescription(row[11]);
                products.setBrand(row[12]);
                products.setBrandId(row[13]);
                products.setColour(row[14]);
                productService.saveProduct(products);
            System.out.println("products values"+products);

        }
    }
   catch (IOException | ProductAlreadyExistsException ex) {
        ex.printStackTrace();
    }
    }


}
