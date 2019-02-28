package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.User;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface RegistrationService
{
    public User saveUser(User user) throws UserAlreadyExistsException, UserNotFoundException;
    public List<User> getAllUser();
    public boolean deleteUser(int id) throws UserNotFoundException;
    public User updateUser(User user) throws UserNotFoundException;
}
