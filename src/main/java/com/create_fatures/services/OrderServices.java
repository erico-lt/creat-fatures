package com.create_fatures.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create_fatures.entites.Order;
import com.create_fatures.repositories.OrderRepository;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderRepository.findAll();
    }

    public Order findById (Long id) {

        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}