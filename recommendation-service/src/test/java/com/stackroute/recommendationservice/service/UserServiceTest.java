//package com.stackroute.recommendationservice.service;
//
//import com.stackroute.rabbitmq.domain.User;
//import com.stackroute.recommendationservice.Repository.UserRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//public class UserServiceTest {
//    User user;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl userService;
//    List<User> list = null;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        user = new User();
//        user.setDob("28/08/1996");
//        user.setPassword("abc@gmail.com");
//        user.setGender("Female");
//        user.setMobileNo("7995947734");
//        user.setUserId(1);
//        user.setUserName("Geetha");
//        list = new ArrayList<>();
//        list.add(user);
//    }
//
//    @Test
//    public void saveUserTest()
//    {
//        when(userRepository.save((User)any())).thenReturn(user);
//        User savedUser = userService.createUser(user);
//        Assert.assertEquals(user,savedUser);
//    }
//
//    @Test
//    public void getUsersTest() {
//        userRepository.save(user);
//        when(userRepository.findAll()).thenReturn(list);
//        List<User> userList = userService.getAllUser();
//        Assert.assertEquals(list, userList);
//    }
//}
