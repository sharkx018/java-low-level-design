package DesignPattern.state;

public class HasMoneyState implements State{

    @Override
    public void insertDollar(VendingMachine context, float dollar) {
        System.out.println("Already has dollar");
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("Returning dollar: $"+context.getDollar());
        context.setState(new HasNoMoneyState());
    }

    @Override
    public void dispense(VendingMachine context) {
        System.out.println("Dispensing the item");
        context.setDollar(0);
        context.setState(new HasNoMoneyState());

    }
}