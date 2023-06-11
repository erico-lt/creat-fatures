package com.create_fatures.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.create_fatures.entites.Clients;
import com.create_fatures.services.ClientsServices;

@Controller
@RequestMapping(value = "/clients")
public class ClientsResources {
    
    @Autowired
    private ClientsServices clientsServices;

    @GetMapping
    public ResponseEntity<List<Clients>> findAll() {

        return ResponseEntity.ok().body(clientsServices.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Clients> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(clientsServices.findById(id));
    }
}
