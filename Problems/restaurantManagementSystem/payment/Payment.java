package Problems.restaurantManagementSystem.payment;

public class Payment {
    private String id;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;

    public Payment(String id, double amount, PaymentMethod method, PaymentStatus status){
        this.id = id;
        this.amount = amount;
        this.paymentMethod = method;
        this.paymentStatus = status;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }



}
