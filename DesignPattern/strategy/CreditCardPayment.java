package DesignPattern.strategy;

public class CreditCardPayment implements PaymentStrategy {

    private String cardHolderName;
    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;


    CreditCardPayment(String cardHolderName, String cardNumber, String cardExpiry, String cardCVV){
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Payment done via CreditCard, amount: "+amount);
    }
}