package Problems.onlineStockBrokerageSystem;

public class Account {

    private String id;
    private User user;
    private double balance;
    private Portfolio portfolio;

    Account(String id, User user, double initialBalance){
        this.id = id;
        this.user = user;
        this.balance = initialBalance;
        this.portfolio = new Portfolio(this);
    }


    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        this.balance = amount;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

}


