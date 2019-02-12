package com.stackroute.userregistrationservice.service;

import com.stackroute.userregistrationservice.domain.Registration;
import com.stackroute.userregistrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.userregistrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface RegistrationService
{
    public Registration saveUser(Registration registration) throws UserAlreadyExistsException, UserNotFoundException;
    public List<Registration> getAllUser();
    public boolean deleteUser(String id) throws UserNotFoundException;
    public Registration updateUser(String pass, String mail, String id) throws UserNotFoundException;
}
