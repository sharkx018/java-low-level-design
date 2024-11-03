package Problems.coffeeVendingMachine.payment;

public class UpiPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}