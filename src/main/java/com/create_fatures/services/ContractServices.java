package com.create_fatures.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create_fatures.entites.Contract;
import com.create_fatures.repositories.ContractRepository;

@Service
public class ContractServices {
    
    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> findAll() {
        
        return contractRepository.findAll();
    }

    public Contract findById(Long id) {

        Optional<Contract> obj = contractRepository.findById(id);
        return obj.get();
    }
} 
