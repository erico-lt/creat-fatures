package com.create_fatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.create_fatures.entites.Installment;

public interface InstallmentRepository  extends JpaRepository<Installment, Long>{
    
}
