package com.stackroute.recommendationservice.service;


import com.stackroute.domain.User;
import com.stackroute.recommendationservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    UserRepository userRepository;

    @Autowired

    public UserServiceImpl(UserRepository userRepository) {
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
}
