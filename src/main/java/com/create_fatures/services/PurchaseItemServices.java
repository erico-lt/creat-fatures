package com.create_fatures.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create_fatures.entites.PurchaseItem;
import com.create_fatures.repositories.PurchaseItemRepository;

@Service
public class PurchaseItemServices {
    
    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    public List<PurchaseItem> findAll() {        
        
        return purchaseItemRepository.findAll();
    }

    public PurchaseItem findById(Long id) {

        Optional<PurchaseItem> obj = purchaseItemRepository.findById(id);
        return obj.get();
    } 
    
}
