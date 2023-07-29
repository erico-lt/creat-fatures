package com.create_fatures.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create_fatures.entites.Installment;
import com.create_fatures.repositories.InstallmentRepository;

@Service
public class InstallmentServices {
    
    @Autowired
    private InstallmentRepository installmentRepository;

    public List<Installment> findAll() {

        return installmentRepository.findAll();
    }

    public Installment findById(Long id) {
        
        Optional<Installment> obj = installmentRepository.findById(id);
        return obj.get();
    }
}
