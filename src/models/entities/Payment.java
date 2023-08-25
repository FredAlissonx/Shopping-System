package models.entities;

public class Payment {
    private String paymentMethod;
    private Double amount;
    private PaymentStatus paymentStatus;
    public Payment(){
    }

    public Payment(String paymentMethod, Double amount, PaymentStatus paymentStatus) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void processPayment(){

    }
}
