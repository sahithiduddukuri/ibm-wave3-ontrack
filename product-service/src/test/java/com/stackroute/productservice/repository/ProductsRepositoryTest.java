//
//package com.stackroute.productservice.repository;
//import com.stackroute.productservice.domain.Products;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class ProductsRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//    private Products products;
//
//    @Before
//    public void setUp()
//    {
//        this.products = new Products();
//        this.products.setProductId("100");
//       this.products.setProductName("Raymond shoe");
//        this.products.setProductType("good");
//        this.products.setImageURL("hkjh nkj");
//        this.products.setMrp("2000");
//        this.products.setPrice("1499");
//        this.products.setDimension("14*10*5");
//        this.products.setWeight("750gm");
//        this.products.setSize("4,5,6,7,8,9");
//        this.products.setGender("Women");
//        this.products.setDescription("Raymond shoes for Women");
//        this.products.setBrand("Raymond");
//        this.products.setColour("Black");
//    }
//    @After
//    public void tearDown(){
//
//        this.productRepository.deleteAll();
//    }
//
//
//
//    @Test
//    public void testSaveProduct(){
//        this.productRepository.save(this.products);
//        Products fetchProducts = this.productRepository.findById(this.products.getProductId()).get();
//        Assert.assertEquals("100", fetchProducts.getProductId());
//
//    }
//
//
//
//    @Test
//    public void testSaveProductFailure(){
//        Products testUser = new Products("101","Bata Shoe for women","formal shoe","h_Red-Tape-Men-Off-White-Walking-Shoes-7341530609306715-1.jpg",
//                "2000","1899","14*10*5","700gm","8,9,10","women","bata shoes for women","Bata","White");
//        this.productRepository.save(products);
//        Products fetchUser = this.productRepository.findById(this.products.getProductId()).get();
//        Assert.assertNotSame(testUser, this.products);
//    }
//
//    @Test
//    public void testGetAllProducts(){
//        Products u = new Products();
//        Products u1 = new Products("100","Bata Shoe for women","formal shoe","h_Red-Tape-Men-Off-White-Walking-Shoes-7341530609306715-1.jpg",
//                "2000","1899","14*10*5","700gm","8,9,10","women","bata shoes for women","Bata","White");
//        this.productRepository.save(u);
//        this.productRepository.save(u1);
//
//        List<Products> list = this.productRepository.findAll();
//        Assert.assertEquals("Bata Shoe for women",list.get(1).getProductName());
//
//    }
//}
