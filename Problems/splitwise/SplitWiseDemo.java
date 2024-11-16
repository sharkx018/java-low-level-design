package Problems.splitwise;

import Problems.splitwise.splits.EqualSplit;
import Problems.splitwise.splits.Split;

import java.util.Arrays;
import java.util.Map;

public class SplitWiseDemo {

    public static void main(String[] args) {
        SplitWiseService instance = SplitWiseService.getInstance();

        // create users
        User user1 = new User("U001", "Mukul", "mukul@gmail.com");
        User user2 = new User("U002", "Yunus", "yunus@gmail.com");
        User user3 = new User("U003", "Farhan", "farhan@gmail.com");

        instance.addUser(user1);
        instance.addUser(user2);
        instance.addUser(user3);

        // create group

        Group group = new Group("G001", "Fatehpur");
        instance.addGroup(group);

        // add expense and splits
        Expense exp = new Expense("E00", "Irani chai", user1, 90);
        Split s1 = new EqualSplit(user1);
        Split s2 = new EqualSplit(user2);
        Split s3 = new EqualSplit(user3);
        exp.addSplits(s1);
        exp.addSplits(s2);
        exp.addSplits(s3);

        instance.addExpense(group.getId(), exp);

        // print user balances
        for(User user: Arrays.asList(user1, user2, user3)){
            System.out.println("User: " + user.getName());
            for(Map.Entry<String , Double> entry: user.getBalances().entrySet()){
                System.out.println("Balance with " + entry.getKey() +": " + entry.getValue());
            }
        }
        System.out.println();
        System.out.println();

        // settle balances
        instance.settleBalance(user1.getId(), user3.getId());
//        instance.settleBalance(user1.getId(), user2.getId());

        // print Transactions
        System.out.println("Transactions: ");
        for(Transaction transaction: instance.getTransactions().values()){
            System.out.println(transaction.getSender().getName() + " send " + transaction.getReceiver().getName() + " : Rs " + transaction.getAmount());
        }
        System.out.println();
        System.out.println();


        // print user balances
        for(User user: Arrays.asList(user1, user2, user3)){
            System.out.println("User: " + user.getName());
            for(Map.Entry<String , Double> entry: user.getBalances().entrySet()){
                System.out.println("Balance with " + entry.getKey() +": " + entry.getValue());
            }
        }
        System.out.println();
        System.out.println();


    }
}
