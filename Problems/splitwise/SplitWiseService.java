package Problems.splitwise;

import Problems.splitwise.splits.EqualSplit;
import Problems.splitwise.splits.PercentageSplit;
import Problems.splitwise.splits.Split;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SplitWiseService {
    private static SplitWiseService instance;
    private Map<String, User> users;
    protected Map<String, Group> groups;
    protected Map<String, Transaction> transactions;

    private SplitWiseService(){
        users = new ConcurrentHashMap<>();
        groups = new ConcurrentHashMap<>();
        transactions = new ConcurrentHashMap<>();
    }

    public static synchronized SplitWiseService getInstance(){
        if(instance == null){
            instance = new SplitWiseService();
        }
        return instance;
    }

    public void addUser(User user){
        this.users.put(user.getId(), user);
    }

    public void addGroup(Group group){
        this.groups.put(group.getId(), group);
    }

    public void addExpense(String groupId, Expense expense){
        Group group = this.groups.get(groupId);
        if(group == null){
            System.out.println("Group not found");
            return;
        }

        // add the expense in group
        group.addExpense(expense);

        // split the expense
        splitExpense(expense);

        // update the balances;
        updateBalances(expense);

    }

    private void splitExpense(Expense expense){
        double totalAmount = expense.getAmount();
        double n = expense.getSplits().size();
        double equalSplitAmount = totalAmount/n;

        for(Split split: expense.getSplits()){
            if(split instanceof EqualSplit){
                split.setAmount(equalSplitAmount);
            }else if(split instanceof PercentageSplit percentageSplit){
                split.setAmount(totalAmount * percentageSplit.getPercent()/100.0);
            }
        }
    }

    public Map<String, Transaction> getTransactions() {
        return transactions;
    }

    private void updateBalances(Expense expense){
        for(Split split: expense.getSplits()){
            User paidBy = expense.getPaidBy();
            User user = split.getUser();
            double amount = split.getAmount();

            updateSplitBalance(paidBy, user, amount);
            updateSplitBalance(user, paidBy, -1 * amount);
        }
    }

    private void updateSplitBalance(User user1, User user2, double amount){
        String balanceKey =  getBalanceKey(user1, user2);
        amount = user1.getBalances().getOrDefault(balanceKey, 0.0) + amount;
        user1.getBalances().put(balanceKey, amount);

    }

    private String getBalanceKey(User user1, User user2){
        return user1.getId() + ":" + user2.getId();
    }

    public void settleBalance(String userId1, String  userId2){
        User user1 = this.users.get(userId1);
        User user2 = this.users.get(userId2);

        if(user1 == null || user2 == null){
            System.out.println("One of the user not found");
            return;
        }

        String balanceKey = getBalanceKey(user1, user2);
        double balance = user1.getBalances().get(balanceKey);

        Transaction t1 = null;

        if(balance > 0){
            t1 = new Transaction(generateTransactionId(), user2, user1, balance);

        }else if (balance < 0){
            t1 = new Transaction(generateTransactionId(), user1, user2, -1*balance);
        }

        user1.getBalances().put(getBalanceKey(user1, user2), 0.0);
        user2.getBalances().put(getBalanceKey(user2, user1), 0.0);

        this.transactions.put(t1.getTransactionId(), t1);

    }

    private  String generateTransactionId(){
        return UUID.randomUUID().toString();
    }



}
