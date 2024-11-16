package Problems.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String id, String name){
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addUsers(User user){
        this.members.add(user);
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<User> getMembers() {
        return members;
    }


}
