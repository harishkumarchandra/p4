package com.example.demo.controllers;

import com.example.demo.model.persistence.repositories.ItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void getItems() {
        Assert.assertNotNull(itemController.getItems());
    }

    @Test
    public void getItemById() {
        Assert.assertNotNull(itemController.getItemById(1L));
    }

    @Test
    public void getItemsByName() {
        Assert.assertNotNull(itemController.getItemsByName("testUser"));
    }
}