package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User createUser(User user);
}
