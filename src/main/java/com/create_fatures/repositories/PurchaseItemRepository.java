package com.create_fatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.create_fatures.entites.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long>{    
}
