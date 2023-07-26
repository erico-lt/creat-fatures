package com.create_fatures.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    private LocalDate dueDate;
    private double amount;
    private Long cnpj;
    private Long cpf;    
    DateTimeFormatter stf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Installment() {
        
    }
    
    public Installment(LocalDate dueDate, double amount, Long cpf) {
        this.setDueDate(dueDate);
        this.setAmount(amount); 
        this.setCpf(cpf);        
    } 

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

     public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

}