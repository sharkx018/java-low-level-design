package DesignPattern.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        BitcoinPayment bitcoinPayment = new BitcoinPayment("lksdnfjksdnf");
        CreditCardPayment creditCardPayment = new CreditCardPayment("Mukul", "123-123", "04/30", "665");

        cart.setPaymentStrategy(bitcoinPayment);
        cart.checkout(123);

        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(454);
    }
}