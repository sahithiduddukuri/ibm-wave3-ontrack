package com.stackroute.recommendationservice.service;


import com.stackroute.recommendationservice.Repository.UserRepository;
import com.stackroute.recommendationservice.domain.Address;
import com.stackroute.recommendationservice.domain.User;
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
        String name = user.getName();
        String userId = user.getUserId();
        String gender = user.getGender();
        String dateofBirth = user.getDateofBirth();
        String password = user.getPassword();
        String mobileNo = user.getMobileNo();
        Address address = user.getAddress();
        User savedUser = userRepository.createUser(name,userId,gender,dateofBirth,mobileNo,password,address);
        return savedUser;
    }
}
