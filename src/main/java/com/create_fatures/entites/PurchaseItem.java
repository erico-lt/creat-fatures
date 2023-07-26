package com.create_fatures.entites;

import java.io.Serializable;

import com.create_fatures.pk.PurchaseItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_purchase_item")
public class PurchaseItem implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PurchaseItemPK id = new PurchaseItemPK();

    private Integer quantity;

    private Double price;       
    
    public PurchaseItem(){        
    }

    public PurchaseItem(Order purchaseOrder, Item item, Integer quantity, Double price) {
        this.setPurchaseOrder(purchaseOrder);
        this.setItem(item);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getPurchaseOrder() {
        return this.id.getPurchaseOrder();
    }

    public void setPurchaseOrder(Order purchaseOrder) {
        this.id.setPurchaseOrder(purchaseOrder);
    }

    public Item getItem() {
        return this.id.getItem();
    }

    public void setItem(Item item) {
        this.id.setItem(item);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return this.getQuantity() * this.getPrice();
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
        PurchaseItem other = (PurchaseItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
