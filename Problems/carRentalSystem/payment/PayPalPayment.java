package Problems.carRentalSystem.payment;


public class PayPalPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // process the PaypalPayment
        return true;
    }
}