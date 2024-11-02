package Problems.carRentalSystem.payment;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        // process the credit card payment
        return true;
    }
}