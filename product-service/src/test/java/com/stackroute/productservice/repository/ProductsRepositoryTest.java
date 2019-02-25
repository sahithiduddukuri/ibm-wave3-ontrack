package com.stackroute.productservice.repository;
import com.stackroute.productservice.domain.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataMongoTest
public class ProductsRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    private Product products;

    @Before
    public void setUp()
    {
        products = new Product();
        products.setProductId(120);
        products.setProductName("Raymond shoe");
        products.setProductType("good");
        products.setImageURL("hkjh nkj");
        products.setMrp("2000");
        products.setPrice("1499");
        products.setDimension("14*10*5");
        products.setWeight("750gm");
        products.setSize("4,5,6,7,8,9");
        products.setGender("Women");
        products.setDescription("Raymond shoes for Women");
        products.setBrand("Raymond");
        products.setColour("Black");
    }
    @After
    public void tearDown(){

        productRepository.deleteAll();
    }



    @Test
    public void testSaveProduct(){
        productRepository.save(products);
        Product fetchProducts = productRepository.findById(products.getProductId()).get();
        Assert.assertEquals(120, fetchProducts.getProductId());

    }



    @Test
    public void testSaveProductFailure(){
        Product testUser = new Product(11100,"Bata Shoe for women","formal shoe","h_Red-Tape-Men-Off-White-Walking-Shoes-7341530609306715-1.jpg",
                "2000","1899","14*10*5","700gm","8,9,10","women","bata shoes for women","Bata","White");
        productRepository.save(products);
        Product fetchUser = productRepository.findById(products.getProductId()).get();
        Assert.assertNotSame(testUser, products);
    }

    @Test
    public void testGetAllProducts(){
        Product u = new Product();
        Product u1 = new Product(22200,"Bata Shoe for women","formal shoe","h_Red-Tape-Men-Off-White-Walking-Shoes-7341530609306715-1.jpg",
                "2000","1899","14*10*5","700gm","8,9,10","women","bata shoes for women","Bata","White");
        productRepository.save(u);
        productRepository.save(u1);

        List<Product> list = productRepository.findAll();
        Assert.assertEquals("Bata Shoe for women",list.get(1).getProductName());

    }
}
