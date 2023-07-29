package com.create_fatures.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.create_fatures.entites.Installment;
import com.create_fatures.services.InstallmentServices;

@RestController
@RequestMapping(value = "/installment")
public class IntallmentResource {
    
    @Autowired
    private InstallmentServices installmentServices;

    @GetMapping
    public ResponseEntity<List<Installment>> findAll() {
        
        return ResponseEntity.ok().body(installmentServices.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Installment> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(installmentServices.findById(id));
    } 
}
