package com.create_fatures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.create_fatures.entites.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long>{
    
}
