package com.create_fatures.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private LocalDate date;
    private double totalValue;   

    private List<Installment> listInstallment = new ArrayList<Installment>();

    public Contract(int number, LocalDate date, double totalValue) {
        this.setNumber(number);
        this.setDate(date);
        this.setTotalValue(totalValue);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getListInstallment() {
        return listInstallment;
    }

    public void addContract(Installment installment) {
        this.listInstallment.add(installment);
    }

}