package com.example.demo.controllers;

import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.OrderRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    String username = "testUser";

    @Test
    public void submitNegativeTest() {
        Assert.assertNotNull(orderController.submit(username));
    }

    @Test
    public void submit() {
        User user = new User();
        Item item = new Item();
        Cart cart = new Cart();
        cart.setItems(Arrays.asList(item));
        user.setCart(cart);
        user.setId(1L);
        when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);
        Assert.assertNotNull(orderController.submit(username));
    }

    @Test
    public void getOrdersForUserNegativeTest() {
        Assert.assertNotNull((orderController.getOrdersForUser(username)));
    }

    @Test
    public void getOrdersForUser() {
        User user = new User();
        when(userRepository.findByUsername(username)).thenReturn(user);
        Assert.assertNotNull((orderController.getOrdersForUser(username)));
    }
}