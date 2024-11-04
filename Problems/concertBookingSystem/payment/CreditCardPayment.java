package Problems.concertBookingSystem.payment;

import Problems.concertBookingSystem.payment.PaymentProcessor;

public class CreditCardPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}