package Problems.digitalWallet;

import java.math.BigDecimal;
import java.util.List;

public class DigitalWalletDemo {

    public static void main(String[] args) {
        DigitalWallet digitalWallet = DigitalWallet.getInstance();

        // create users
        User user1 = new User("U001", "mukul@gmail.com", "123");
        User user2 = new User("U002", "aryan@gmail.com", "123");

        digitalWallet.addUser(user1);
        digitalWallet.addUser(user2);

        // create accounts
        Account account1 = new Account("A001", "23423324", user1, Currency.USD);
        Account account2 = new Account("A002", "65756756", user2, Currency.INR);

        digitalWallet.addAccount(account1);
        digitalWallet.addAccount(account2);

        // add payment methods
        PaymentMethod paymentMethod1 = new CreditCardPayment("P001", "credit-card", "4444444", "Mukul Verma", "33/99");
        PaymentMethod paymentMethod2 = new NetBanking("P002", "net-banking", "4444444", "dsfsdfsdfsdfsd");

        digitalWallet.addPaymentMethod(account1, paymentMethod1);
        digitalWallet.addPaymentMethod(account2, paymentMethod2);

        // deposit funds
        account1.creditBalance(new BigDecimal(300));
        account2.creditBalance(new BigDecimal(500));

        // fund transfer
        digitalWallet.transferMoney(account1, account2, new BigDecimal(1), Currency.USD);

        // show balance
        System.out.println("account1 balance: " + account1.getCurrency() + " " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getCurrency() + " " + account2.getBalance());

        // show transactions
        List<Transaction> transactions1 = account1.getTransactions();
        List<Transaction> transactions2 = account2.getTransactions();

        System.out.println("Transaction History for account 1:");
        for(Transaction transaction: transactions1){
            System.out.println("Transaction Id:" + transaction.getId());
            System.out.println(" Amount:" + transaction.getAmount());
            System.out.println(" Currency:" + transaction.getCurrency());
            System.out.println(" Timestamp:" + transaction.getTimestamp());
        }

        System.out.println("Transaction History for account 2:");
        for(Transaction transaction: transactions2){
            System.out.println("Transaction Id:" + transaction.getId());
            System.out.println(" Amount:" + transaction.getAmount());
            System.out.println(" Currency:" + transaction.getCurrency());
            System.out.println(" Timestamp:" + transaction.getTimestamp());
        }

        System.out.println();

    }

}