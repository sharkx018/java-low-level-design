package Problems.airlineManagementSystem.payment;

public class Payment {
    private final String paymentId;
    private final String paymentMethod;
    private final double amount;
    private PaymentStatus status;

    Payment(String paymentId, String paymentMethod, double amount){
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public void processPayment(){
        status = PaymentStatus.COMPLETED;
    }



}