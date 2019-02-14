package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.Registration;
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
    private Registration registration;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository)
    {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration saveUser(Registration registration) throws UserAlreadyExistsException, UserNotFoundException {
//        Optional optional = registrationRepository.findById(registration.getUserId());
//        if((optional.isPresent()))
//        {
//            throw new UserAlreadyExistsException();
//        }
//        return registrationRepository.insert(registration);
        if(registrationRepository.existsById(registration.getId()))
        {
            throw new UserAlreadyExistsException("User alreasy exists");
        }
        Registration savedUser = registrationRepository.save(registration);
        if(savedUser == null)
        {
            throw new UserAlreadyExistsException();
        }
        return savedUser;
    }

    @Override
    public List<Registration> getAllUser()
    {
        return registrationRepository.findAll();
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
    public Registration updateUser(Registration registration) throws UserNotFoundException {
//        Optional optional = registrationRepository.findById(id);
//        if(optional.isPresent())
//        {
//            registration=registrationRepository.findById(id).get();
//            registration.setPassword(pass);
//            registration.setEmailId(mail);
//            registrationRepository.save(registration);
//        }
//        else
//        {
//            throw new UserNotFoundException();
//        }
//        return registration;
        if(registrationRepository.existsById(registration.getId()))
        {
            Registration updateUser=registrationRepository.save(registration);
            return updateUser;
        }
        else
        {
            throw new UserNotFoundException("User is not exists");
        }
    }
}
