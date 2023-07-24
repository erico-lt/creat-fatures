package com.create_fatures.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class PurchaseOrder {

    private Integer id;
    private LocalDate date;    

    @OneToMany
    private Set<PurchaseItem> itemList = new HashSet<>();
    
    @JsonIgnore
    private List<Installment> listInstallment = new ArrayList<>();
    // private ServicesPurchaseOrder servicesPurchaseOrder = new
    // ServicesPurchaseOrder();

    public PurchaseOrder(LocalDate date, Integer id) {
        this.setDate(date);
        this.setId(id);       
    }    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PurchaseItem> getitemList() {
        return itemList;
    }

    public List<Installment> getListInstallment() {
        return listInstallment;
    }

    public void addInstallment(Installment Installment) {
        this.listInstallment.add(Installment);
    }

    public Double getTotalValue() {
        double valueOrder = 0;
        for(PurchaseItem item: getitemList()) {
            valueOrder = item.getSubTotal();
        }

        return valueOrder;
    }

}