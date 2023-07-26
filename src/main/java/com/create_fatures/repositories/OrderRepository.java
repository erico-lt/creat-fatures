package com.create_fatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.create_fatures.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
