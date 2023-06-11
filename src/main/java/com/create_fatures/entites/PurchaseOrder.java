package com.create_fatures.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import model.services.ServicesPurchaseOrder;

public class PurchaseOrder {
    private LocalDate date;
    private double valueOrder;
    private Integer requestNumber;    

    private List<Item> requestList = new ArrayList<>();
    private List<Installment> listInstallment = new ArrayList<>();
    //private ServicesPurchaseOrder servicesPurchaseOrder = new ServicesPurchaseOrder();

    public PurchaseOrder(LocalDate date, Integer requestNumber) {
        this.setDate(date);
        this.setRequestNumber(requestNumber);        
        this.setValueOrder(0);
    }

    /* 
    public void addItemForSale(Item item) {
        if (!servicesPurchaseOrder.codPorductExist(this.getRequestList(), item)) {
            this.getRequestList().add(item);
        } else{
            for(Item ite: this.getRequestList()) {
                if(ite.getName().toUpperCase().equals(item.getName().toUpperCase())) {
                    ite.setQuant(ite.getQuant() + item.getQuant());
                }
            }
        }
        this.setValueOrder(this.getValueOrder() + servicesPurchaseOrder.valueOrder(item));
    }*/

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValueOrder() {
        return valueOrder;
    }

    private void setValueOrder(double valueOrder) {
        this.valueOrder = valueOrder;
    }

    public Integer getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Integer requestNumber) {
        this.requestNumber = requestNumber;
    }

    public List<Item> getRequestList() {
        return requestList;
    }

    public List<Installment> getListInstallment() {
        return listInstallment;
    }

    public void addInstallment(Installment Installment) {
        this.listInstallment.add(Installment);
    }

}