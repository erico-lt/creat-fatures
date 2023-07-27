package com.create_fatures.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_installments")
public class Installment {      

    @Id
    private Long id;

    @ManyToOne
    @MapsId
    private Order order;      
 
    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getAmout() {

        return String.format("Full value: %.2f", this.order.getTotalValue());
    }   

}