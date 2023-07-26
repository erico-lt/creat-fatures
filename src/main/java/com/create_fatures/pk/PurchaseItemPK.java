package com.create_fatures.pk;

import java.io.Serializable;

import com.create_fatures.entites.Item;
import com.create_fatures.entites.Order;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PurchaseItemPK implements Serializable{
    public static final long serialSersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private Order purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Order getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(Order newPurchaseOrder) {
        this.purchaseOrder = newPurchaseOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((purchaseOrder == null) ? 0 : purchaseOrder.hashCode());
        result = prime * result + ((item == null) ? 0 : item.hashCode());
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
        PurchaseItemPK other = (PurchaseItemPK) obj;
        if (purchaseOrder == null) {
            if (other.purchaseOrder != null)
                return false;
        } else if (!purchaseOrder.equals(other.purchaseOrder))
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        return true;
    }     

}
