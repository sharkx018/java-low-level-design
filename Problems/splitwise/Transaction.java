package Problems.splitwise;

public class Transaction {
    private String transactionId;
    private User sender;
    private User receiver;
    private double amount;

    public Transaction(String transactionId, User sender, User receiver, double amount){
        this.transactionId = transactionId;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
