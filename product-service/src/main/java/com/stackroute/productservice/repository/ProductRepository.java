package com.stackroute.productservice.repository;

import com.stackroute.productservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
<<<<<<< HEAD
public interface ProductRepository extends MongoRepository<Product,Integer> {
=======
public interface ProductRepository extends MongoRepository<Products, String> {
>>>>>>> 1fbdd5c34115e63bd147ca6077b7dbb1191f79a7
}
