package com.create_fatures.entites;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-HH", timezone = "GMT")
    private Instant date;   
    
    @ManyToOne
    private Clients client; 

    @OneToMany(mappedBy = "id.purchaseOrder")
    private Set<PurchaseItem> itemList = new HashSet<>();    

    @OneToOne(mappedBy = "order")
    private Installment listInstallment;

    public Order() {
    }

    public Order(Long id, Instant date, Clients client) {
        this.setId(id);
        this.setDate(date);        
        this.setClients(client);
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

    public Installment getListInstallment() {
        return listInstallment;
    }

    public void setListInstallment(Installment listInstallment) {
        this.listInstallment = listInstallment;
    }

    public Set<PurchaseItem> getItemList() {
        return itemList;
    }
     
    public Clients getClients() {
        return client;
    }

    public void setClients(Clients client) {
        this.client = client;
    }
    
    public Double getTotalValue() {     
        double valueOrder = 0;
        for (PurchaseItem item : getItemList()) {
            valueOrder += item.getSubTotal();
        }
        return valueOrder;
    }       

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }  
}