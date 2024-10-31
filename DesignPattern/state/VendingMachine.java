package DesignPattern.state;

public class VendingMachine {

    private State currentState;
    private float dollar;

    public VendingMachine(){
        this.currentState = new HasNoMoneyState();

    }

    public float getDollar(){
        return this.dollar;
    }

    public void setDollar(float dollar){
        this.dollar = dollar;
    }

    public void setState(State state){
        this.currentState = state;
    }

    public void insertMoney(float dollar){
        this.dollar = dollar;
        this.currentState.insertDollar(this, dollar);
    }


    public void ejectMoney(){
        this.currentState.ejectMoney(this);
    }


    public void dispense(){
        this.currentState.dispense(this);
    }

}