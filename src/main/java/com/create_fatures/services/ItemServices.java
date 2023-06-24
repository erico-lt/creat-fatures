package com.create_fatures.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create_fatures.entites.Item;
import com.create_fatures.repositories.ItemRepository;

@Service
public class ItemServices {
    
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        Optional<Item> obj = itemRepository.findById(id);
        return obj.get();
    }
}
