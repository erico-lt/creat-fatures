package com.create_fatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.create_fatures.entites.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
