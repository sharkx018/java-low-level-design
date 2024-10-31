package DesignPattern.state;

interface State{
    void insertDollar(VendingMachine context, float dollar);
    void ejectMoney(VendingMachine context);
    void dispense(VendingMachine context);

}