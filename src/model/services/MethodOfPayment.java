package model.services;

import java.time.LocalDate;
import model.entites.Installment;
import model.entites.PurchaseOrder;
import model.interfaces.OlinePaymentService;

public class MethodOfPayment {

    private OlinePaymentService olinePaymentService;

    public MethodOfPayment(OlinePaymentService olinePaymentService) {
        this.setOlinePaymentService(olinePaymentService);
    }
    
    public void processContract(PurchaseOrder purchaseOrder, int months, Long cnpj, Long insState) {        
        double valuePerMonth = purchaseOrder.getValueOrder() / months;

        if(purchaseOrder.getListInstallment().size() != 0) {
            purchaseOrder.getListInstallment().clear();
        }

        for (int cont = 1; cont <= months; cont++) {
            LocalDate nextDueDate = purchaseOrder.getDate().plusMonths(cont);

            double interest = this.getOlinePaymentService().interest(valuePerMonth, cont);
            double fee = this.getOlinePaymentService().paymentFee(valuePerMonth + interest);
            double totalvalue = valuePerMonth + fee + interest;

            purchaseOrder.addInstallment(new Installment(nextDueDate, totalvalue, cnpj, insState));

        }
    }

    public void processContract(PurchaseOrder purchaseOrder, int months, Long cpf) {
        double valuePerMonth = purchaseOrder.getValueOrder() / months;
        
        if(purchaseOrder.getListInstallment().size() != 0) {
            purchaseOrder.getListInstallment().clear();
        }

        for (int cont = 1; cont <= months; cont++) {
            LocalDate nextDueDate = purchaseOrder.getDate().plusMonths(cont);

            double interest = this.getOlinePaymentService().interest(valuePerMonth, cont);
            double fee = this.getOlinePaymentService().paymentFee(valuePerMonth + interest);
            double totalvalue = valuePerMonth + fee + interest;

            purchaseOrder.addInstallment(new Installment(nextDueDate, totalvalue, cpf));

        }
    }

    /*
     * public void processContract(Contract contract, int months, Long cnpj, Integer
     * inscState) {
     * double valuePerMonth = contract.getTotalValue() / months;
     * 
     * for (int cont = 1; cont <= months; cont++) {
     * LocalDate nextDueDate = contract.getDate().plusMonths(cont);
     * 
     * double interest = this.getOlinePaymentService().interest(valuePerMonth,
     * cont);
     * double fee = this.getOlinePaymentService().paymentFee(valuePerMonth +
     * interest);
     * double totalvalue = valuePerMonth + fee + interest;
     * 
     * contract.addContract(new Installment(nextDueDate, totalvalue, cnpj,
     * inscState));
     * 
     * }
     * }
     */

    public OlinePaymentService getOlinePaymentService() {
        return olinePaymentService;
    }

    public void setOlinePaymentService(OlinePaymentService olinePaymentService) {
        this.olinePaymentService = olinePaymentService;
    }

}