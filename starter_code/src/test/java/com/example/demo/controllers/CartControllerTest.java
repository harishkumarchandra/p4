package com.example.demo.controllers;

import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.ItemRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.ModifyCartRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

    @InjectMocks
    private CartController cartController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void addTocartNegativeTest() {
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest();
        Assert.assertNotNull(cartController.addTocart(modifyCartRequest));
    }

    @Test
    public void addTocartNegativeTest2() {
        User user = new User();
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest();
        modifyCartRequest.setUsername("testUser");
        when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);
        Assert.assertNotNull(cartController.addTocart(modifyCartRequest));
    }

    @Test
    public void addTocart() {
        User user = new User();
        Item item = new Item();
        Optional<Item> optionalItem = Optional.of(item);
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest();
        modifyCartRequest.setUsername("testUser");
        modifyCartRequest.setItemId(1L);
        when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);
        when(itemRepository.findById(Mockito.anyLong())).thenReturn(optionalItem);
        Assert.assertNotNull(cartController.addTocart(modifyCartRequest));
    }

    @Test
    public void removeFromcartNegativeTest() {
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest();
        Assert.assertNotNull(cartController.removeFromcart(modifyCartRequest));
    }

    @Test
    public void removeFromcartNegativeTest2() {
        User user = new User();
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest();
        modifyCartRequest.setUsername("testUser");
        when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);
        Assert.assertNotNull(cartController.removeFromcart(modifyCartRequest));
    }

    @Test
    public void removeFromcart() {
        User user = new User();
        Item item = new Item();
        Optional<Item> optionalItem = Optional.of(item);
        ModifyCartRequest modifyCartRequest = new ModifyCartRequest();
        modifyCartRequest.setUsername("testUser");
        modifyCartRequest.setItemId(1L);
        when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);
        when(itemRepository.findById(Mockito.anyLong())).thenReturn(optionalItem);
        Assert.assertNotNull(cartController.removeFromcart(modifyCartRequest));
    }
}