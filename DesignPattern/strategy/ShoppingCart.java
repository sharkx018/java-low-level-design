package DesignPattern.strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    ShoppingCart(){}

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        this.paymentStrategy.pay(amount);
    }

}