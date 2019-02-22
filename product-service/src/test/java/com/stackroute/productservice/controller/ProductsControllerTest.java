//package com.stackroute.productservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.productservice.domain.Products;
//import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
//import com.stackroute.productservice.service.ProductService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class ProductsControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private Products products;
//    @MockBean
//    private ProductService productService;
//    @InjectMocks
//    private ProductController productController;
//
//    private List<Products> list =null;
//
//    @Before
//    public void setUp(){
//
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//        products = new Products();
//       products.setProductId(120);
//       products.setProductName("Raymond shoe");
//       products.setProductType("good");
//       products.setImageURL("hkjh nkj");
//       products.setMrp("2000");
//       products.setPrice("1499");
//       products.setDimension("14*10*5");
//       products.setWeight("750gm");
//       products.setSize("4,5,6,7,8,9");
//       products.setGender("Women");
//       products.setDescription("Raymond shoes for Women");
//       products.setBrand("Raymond");
//       products.setColour("Black");
//
//        list = new ArrayList();
//
//        list.add(products);
//    }
//    @Test
//    public void saveProduct() throws Exception {
//        when(productService.saveProduct(any())).thenReturn(products);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(products)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void deleteProduct() throws Exception {
//        when(productService.deleteProduct(products.getProductId())).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/products/{id}", products.getProductId())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(products)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void deleteProductFailure() throws Exception, ProductIdNotFoundException {
//        when(productService.deleteProduct(products.getProductId())).thenReturn(false);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/products/{id}", products.getProductId())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(products)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void updateproduct() throws Exception {
//        when(productService.updateProduct(any())).thenReturn(products);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/products")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(products)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//    @Test
//    public void getAllTracks() throws Exception {
//        when(productService.getAllProducts()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(products)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//
//
//
//
//
//}
