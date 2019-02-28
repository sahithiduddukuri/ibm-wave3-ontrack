//
//package com.stackroute.productservice.service;
//
//
//import com.stackroute.productservice.domain.Product;
//import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
//import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
//import com.stackroute.productservice.repository.ProductRepository;
//import com.stackroute.rabbitmq.domain.ProductDTO;
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
//public class ProductDTOServiceTest {
//    Product product;
//    ProductDTO productDTO;
//
//    //Create a mock for UserRepository
//    @Mock
//    ProductRepository productRepository;
//
//    //Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    ProductServiceImpl productService;
//    List<ProductDTO> list= null;
//
//
//    @Before
//    public void setUp(){
//        //Initialising the mock object
//        MockitoAnnotations.initMocks(this);
//        productDTO =new ProductDTO();
//        productDTO.setProductId("100");
//        productDTO.setProductName("Raymond shoe");
//        productDTO.setProductType("good");
//        productDTO.setImageURL("hkjh nkj");
//        productDTO.setMrp("2000");
//        productDTO.setPrice("1499");
//        productDTO.setDimension("14*10*5");
//        productDTO.setWeight("750gm");
//        productDTO.setSize("4,5,6,7,8,9");
//        productDTO.setGender("Women");
//        productDTO.setDescription("Raymond shoes for Women");
//        productDTO.setBrand("Raymond");
//        productDTO.setBrandId("1");
//        productDTO.setColour("Black");
//        productDTO.setProductTypeId("1");
//        list = new ArrayList<>();
//        list.add(productDTO);
//
//
//    }
//
//    @Test
//    public void saveProductTestSuccess() throws ProductAlreadyExistsException {
//
//        when(productRepository.save((ProductDTO)any())).thenReturn(productDTO);
//        ProductDTO savedProductDTO = productService.saveProduct(productDTO);
//        Assert.assertEquals(productDTO, savedProductDTO);
//
//        //verify here verifies that userRepository save method is only called once
//        verify(productRepository,times(1)).save(productDTO);
//
//    }
//    @Test(expected = ProductAlreadyExistsException.class)
//    public void saveProductTestFailure() throws ProductAlreadyExistsException {
//        when(productRepository.save((ProductDTO)any())).thenReturn(null);
//        ProductDTO savedProductDTO = productService.saveProduct(productDTO);
//        System.out.println("savedtrack" + savedProductDTO);
//        Assert.assertEquals(productDTO, savedProductDTO);
//
//
//
//    }
//
//
//
//    @Test
//    public void updateProductTest() throws ProductAlreadyUpdatedException
//    {
//        when(productRepository.save((Product)any())).thenReturn(product);
//        ProductDTO updateProductDTO = null;
//        try {
//            updateProductDTO = productService.saveProduct(productDTO);
//        } catch (ProductAlreadyExistsException e) {
//            e.printStackTrace();
//        }
//        Assert.assertEquals(productDTO, updateProductDTO);
//    }
//
//
//
////    @Test
////    public void getAllProducts(){
////
////        productRepository.save(productDTO);
////        //stubbing the mock to return specific data
////        when(productRepository.findAll()).thenReturn(list);
////        List<ProductDTO> tracklist = productService.getAllProducts();
////        Assert.assertEquals(list,tracklist);
////    }
//
//
//
//
//}
