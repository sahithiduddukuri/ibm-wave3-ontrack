package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.User;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService
{
    private RegistrationRepository registrationRepository;
    private User user;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository)
    {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
//        Optional optional = registrationRepository.findById(user.getUserId());
//        if((optional.isPresent()))
//        {
//            throw new UserAlreadyExistsException();
//        }
//        return registrationRepository.insert(user);
        if(registrationRepository.existsById(user.getId()))
        {
            throw new UserAlreadyExistsException("User alreasy exists");
        }
        User savedUser = registrationRepository.save(user);
        if(savedUser == null)
        {
            throw new UserAlreadyExistsException();
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUser()
    {
        return (List<User>) registrationRepository.findAll();
    }

    @Override
    public boolean deleteUser(int id) throws UserNotFoundException {
        boolean status = false;
        Optional optional = registrationRepository.findById(id);
        if(optional.isPresent())
        {
            registrationRepository.deleteById(id);
            status=true;
        }
        else
        {
            throw new UserNotFoundException();
        }
        return status;
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
//        Optional optional = registrationRepository.findById(id);
//        if(optional.isPresent())
//        {
//            user=registrationRepository.findById(id).get();
//            user.setPassword(pass);
//            user.setEmailId(mail);
//            registrationRepository.save(user);
//        }
//        else
//        {
//            throw new UserNotFoundException();
//        }
//        return user;
        if(registrationRepository.existsById(user.getId()))
        {
            User updateUser=registrationRepository.save(user);
            return updateUser;
        }
        else
        {
            throw new UserNotFoundException("User is not exists");
        }
    }

    @Override
    public User getByUserId(String userId) {
        return registrationRepository.findByUserId(userId);
    }
}
