package DesignPattern.state;

public class StatePatternDemo {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();


        vendingMachine.insertMoney(3);
        vendingMachine.dispense();

        System.out.println("-------------");

        vendingMachine.insertMoney(4);
        vendingMachine.insertMoney(4);
        vendingMachine.ejectMoney();
        vendingMachine.dispense();

        System.out.println("-------------");
        vendingMachine.insertMoney(5);
        vendingMachine.dispense();
        vendingMachine.ejectMoney();

    }
}