package com.create_fatures.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.create_fatures.entites.Item;
import com.create_fatures.services.ItemServices;

@RestController
@RequestMapping(value = "/itens")
public class ItemResources {

    @Autowired
    private ItemServices itemServices;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok().body(itemServices.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemServices.findById(id));
    }
}
