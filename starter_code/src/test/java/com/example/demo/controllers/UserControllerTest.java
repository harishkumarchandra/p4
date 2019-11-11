package com.example.demo.controllers;

import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserController userController;

    @Test
    public void findById() {
        Assert.assertNotNull(userController.findById(1L));
    }

    @Test
    public void findByUserName() {
        Assert.assertNotNull(userController.findByUserName("testUser"));
    }

    @Test
    public void createUser() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("testUser");
        userRequest.setPassword("testPassword");
        userRequest.setConfirmPassword("testPassword");
        Assert.assertNotNull(userController.createUser(userRequest));
    }

    @Test
    public void createUserNegativeTest() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("testUser");
        userRequest.setPassword("testPassword");
        userRequest.setConfirmPassword("Password");
        Assert.assertNotNull(userController.createUser(userRequest));
    }
}