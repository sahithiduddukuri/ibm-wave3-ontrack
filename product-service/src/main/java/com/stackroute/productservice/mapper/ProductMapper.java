package com.stackroute.productservice.mapper;


import com.stackroute.productservice.domain.Product;
import com.stackroute.rabbitmq.domain.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {


    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO productToProductDTO(Product product);
}
