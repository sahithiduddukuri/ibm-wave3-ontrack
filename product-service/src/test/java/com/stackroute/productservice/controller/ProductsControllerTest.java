
package com.stackroute.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fridujo.rabbitmq.mock.compatibility.MockConnectionFactoryFactory;
import com.stackroute.productservice.config.RabbitMqConfig;
import com.stackroute.productservice.domain.Product;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import com.stackroute.productservice.service.ProductService;
import com.stackroute.productservice.service.RabbitMqProducer;
import com.stackroute.rabbitmq.domain.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@Import(RabbitMqConfig.class)
public class ProductsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Product product;
    private ProductDTO productDTO;
    @MockBean
    @Autowired
    private ProductService productService;

//    @Autowired
//    RabbitMqProducer rabbitMqProducer;
    @MockBean
    RabbitMqProducer rabbitMqProducer;

    @InjectMocks
    private ProductController productController;

//    @InjectMocks
//    private RabbitMqProducer rabbitMqProducer1;


    private List<Product> list =null;

    @Before
    public void setUp(){
       MockitoAnnotations.initMocks(rabbitMqProducer);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        product = new Product();
       product.setProductId("100");
       product.setProductName("Adidas Women Sport Shoes");
       product.setProductType("Female Sport Shoes");
       product.setImageURL("https://images-na.ssl-images-amazon.com/images/I/816JNuzLw7L._UL1500_.jpg");
       product.setMrp("2040");
       product.setPrice("1820");
       product.setDimension("14*10*5");
       product.setWeight("830gm");
       product.setSize("7,8,9");
       product.setGender("Female");
       product.setDescription("Raymond shoes for Women");
       product.setBrand("Reebok");
       product.setColour("Black");

        list = new ArrayList();

        list.add(product);

        productDTO= new ProductDTO();
        productDTO.setProductId("100");
        productDTO.setProductName("Adidas Women Sport Shoes");
        productDTO.setProductType("Female Sport Shoes");
        productDTO.setImageURL("https://images-na.ssl-images-amazon.com/images/I/816JNuzLw7L._UL1500_.jpg");
        productDTO.setMrp("2040");
        productDTO.setPrice("1820");
        productDTO.setDimension("14*10*5");
        productDTO.setWeight("830gm");
        productDTO.setSize("7,8,9");
        productDTO.setGender("Female");
        productDTO.setDescription("Raymond shoes for Women");
        productDTO.setBrand("Reebok");
        productDTO.setColour("Black");
        rabbitMqProducer.produce(product);
    }

    @Test
    public void saveProduct() throws Exception {
        when(productService.saveProduct(any())).thenReturn(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
                .andExpect(MockMvcResultMatchers.status().isCreated())

                .andDo(MockMvcResultHandlers.print());

       this.rabbitMqProducer.produce(product);

    }
    @Test
    public void deleteProduct() throws Exception {
        when(productService.deleteProduct(product.getProductId())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/product/{id}", product.getProductId())
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void deleteProductFailure() throws Exception, ProductIdNotFoundException {
        when(productService.deleteProduct(product.getProductId())).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/product/{id}", product.getProductId())
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void updateproduct() throws Exception {
        when(productService.updateProduct(any())).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getAllTracks() throws Exception {
        when(productService.getAllProducts()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }








}
