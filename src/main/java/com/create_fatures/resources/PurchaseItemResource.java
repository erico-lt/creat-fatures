package com.create_fatures.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.create_fatures.entites.PurchaseItem;
import com.create_fatures.services.PurchaseItemServices;

@RestController
@RequestMapping(value = "/purchaseitem")
public class PurchaseItemResource {
    
    @Autowired
    private PurchaseItemServices purchaseItemServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PurchaseItem> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(purchaseItemServices.findById(id));
    }
    

    @GetMapping
    public ResponseEntity<List<PurchaseItem>> findAll() {
        
        return ResponseEntity.ok().body(purchaseItemServices.findAll());
    }
    
}
