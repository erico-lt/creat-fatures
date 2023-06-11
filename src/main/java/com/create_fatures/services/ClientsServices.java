package com.create_fatures.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create_fatures.entites.Clients;
import com.create_fatures.repositories.ClientsRepository;

@Service
public class ClientsServices {

    @Autowired    
    private ClientsRepository clientsRepository;
    
    public List<Clients> findAll() {
        return clientsRepository.findAll();
    }

    public Clients findById(Long id) {
        Optional<Clients> obj = clientsRepository.findById(id);
        return obj.get();
    }
}
