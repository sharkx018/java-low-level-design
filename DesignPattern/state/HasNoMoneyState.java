package DesignPattern.state;

public class HasNoMoneyState implements State {


    @Override
    public void insertDollar(VendingMachine context, float dollar) {
        System.out.println("Money inserted: $"+ dollar);
        context.setState(new HasMoneyState());
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("Cannot eject money, reason: No money inserted");
    }

    @Override
    public void dispense(VendingMachine context) {
        System.out.println("Cannot dispense product, reason: No money inserted");
    }
}