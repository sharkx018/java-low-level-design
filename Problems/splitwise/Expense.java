package Problems.splitwise;

import Problems.splitwise.splits.Split;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String id;
    private double amount;
    private String description;
    private User paidBy;
    private List<Split> splits;

    public Expense(String id, String description, User paidBy, double totalAmount){
        this.id = id;
        this.amount = totalAmount;
        this.description = description;
        this.paidBy = paidBy;
        this.splits = new ArrayList<>();
    }

    public void addSplits(Split split){
        this.splits.add(split);
    }

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }


}
