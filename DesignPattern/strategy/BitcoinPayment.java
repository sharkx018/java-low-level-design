package DesignPattern.strategy;

public class BitcoinPayment implements PaymentStrategy {
    private String bitcoinAddress;

    BitcoinPayment(String bitcoinAddress){
        this.bitcoinAddress = bitcoinAddress;
    }



    @Override
    public void pay(int amount) {
        System.out.println("Payment done via Bitcoin, amount: "+amount);
    }
}