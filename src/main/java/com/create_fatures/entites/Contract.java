package com.create_fatures.entites;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ÿyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;    

    @Transient
    private List<Installment> listInstallment = new ArrayList<Installment>();

    public Contract() {        
    }

    public Contract(Long id, Instant date) {
        this.setId(id);
        this.setDate(date);        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public List<Installment> getListInstallment() {
        return listInstallment;
    }

    public void addContract(Installment installment) {
        this.listInstallment.add(installment);
    }



}