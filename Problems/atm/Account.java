package Problems.atm;

public class Account {
    private final String accountNumber;
    private int amount;

    public Account(String accountNumber, int amount){
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void debit(int amount){
        this.amount -= amount;
    }

    public void credit(int amount){
        this.amount += amount;
    }
}