package Problems.atm;

public class CashDispenser {
    private int totalCash;

    public CashDispenser(int totalCash){
        this.totalCash = totalCash;
    }

    public void dispenseCash(int amount){
        if(amount > totalCash){
            throw new IllegalArgumentException("Insufficient cash available in the atm");
        }
        totalCash -= amount;
        System.out.println("Cash Dispense: " + amount);
    }

}