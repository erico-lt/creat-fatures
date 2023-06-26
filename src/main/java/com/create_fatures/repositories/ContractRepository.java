package com.create_fatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.create_fatures.entites.Contract;

public interface ContractRepository  extends JpaRepository<Contract, Long>{
    
}
