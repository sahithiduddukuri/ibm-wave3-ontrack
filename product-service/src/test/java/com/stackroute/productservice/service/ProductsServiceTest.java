//package com.stackroute.productservice.service;
//
//import com.stackroute.productservice.domain.Products;
//import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
//import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
//import com.stackroute.productservice.repository.ProductRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//
//public class ProductsServiceTest {
//    Products products;
//
//    //Create a mock for UserRepository
//    @Mock
//    ProductRepository productRepository;
//
//    //Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    ProductServiceImpl productService;
//    List<Products> list= null;
//
//
//    @Before
//    public void setUp(){
//        //Initialising the mock object
//        MockitoAnnotations.initMocks(this);
//        products =new Products();
//        products.setProductId(120);
//        products.setProductName("Raymond shoe");
//        products.setProductType("good");
//        products.setImageURL("hkjh nkj");
//        products.setMrp("2000");
//        products.setPrice("1499");
//        products.setDimension("14*10*5");
//        products.setWeight("750gm");
//        products.setSize("4,5,6,7,8,9");
//        products.setGender("Women");
//        products.setDescription("Raymond shoes for Women");
//        products.setBrand("Raymond");
//        products.setColour("Black");
//        list = new ArrayList<>();
//        list.add(products);
//
//
//    }
//
//    @Test
//    public void saveProductTestSuccess() throws ProductAlreadyExistsException {
//
//        when(productRepository.save((Products)any())).thenReturn(products);
//        Products savedProducts = productService.saveProduct(products);
//        Assert.assertEquals(products, savedProducts);
//
//        //verify here verifies that userRepository save method is only called once
//        verify(productRepository,times(1)).save(products);
//
//    }
//    @Test(expected = ProductAlreadyExistsException.class)
//    public void saveProductTestFailure() throws ProductAlreadyExistsException {
//        when(productRepository.save((Products)any())).thenReturn(null);
//        Products savedProducts = productService.saveProduct(products);
//        System.out.println("savedtrack" + savedProducts);
//        Assert.assertEquals(products, savedProducts);
//
//       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
//       userService.saveUser(user);*/
//
//
//    }
//
//
//
//    @Test
//    public void updateProductTest() throws ProductAlreadyUpdatedException
//    {
//        when(productRepository.save((Products)any())).thenReturn(products);
//        Products updateProducts = null;
//        try {
//            updateProducts = productService.saveProduct(products);
//        } catch (ProductAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//        Assert.assertEquals(products, updateProducts);
//    }
//
//
//
//    @Test
//    public void getAllProducts(){
//
//        productRepository.save(products);
//        //stubbing the mock to return specific data
//        when(productRepository.findAll()).thenReturn(list);
//        List<Products> tracklist = productService.getAllProducts();
//        Assert.assertEquals(list,tracklist);
//    }
//
//
//
//
//}
