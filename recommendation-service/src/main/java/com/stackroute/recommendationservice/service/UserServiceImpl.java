package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.domain.Product;
import com.stackroute.recommendationservice.domain.User;
import com.stackroute.recommendationservice.repository.ProductRepository;
import com.stackroute.recommendationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class UserServiceImpl {
    UserRepository userRepository;
    ProductRepository productRepository;

    @Autowired
    public UserServiceImpl(ProductRepository productRepository,UserRepository userRepository)
    {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }



    public List<User> getAllUser()
    {
        return (List<User>) userRepository.findAll();
    }

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }


    public Product save(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    public Product updateProduct(Product product) {
        if(productRepository.existsById(product.getType())) {
            Product updateProduct = productRepository.save(product);
            return updateProduct;
        }
        else
        {
            return product;
        }
    }

    public List<Product> getAllproducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Collection<User> getAll()
    {
        System.out.println("erpupureo");
        return userRepository.getAllUsers();
    }

}
