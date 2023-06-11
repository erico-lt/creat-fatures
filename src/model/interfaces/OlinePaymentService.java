package model.interfaces;

public abstract interface OlinePaymentService {
    public abstract double paymentFee(double amount);
    public abstract double interest(double amount, int months);
}
