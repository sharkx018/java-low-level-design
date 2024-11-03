package Problems.coffeeVendingMachine.payment;


public class CreditCardPayment  implements PaymentProcessor {

    private String cardNumber;
    private String cardHolderName;
    private String expiry;

    CreditCardPayment(String cardNumber, String cardHolderName, String expiry){
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiry = expiry;
    }

    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}