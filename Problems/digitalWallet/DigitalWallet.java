package Problems.digitalWallet;

import Problems.cricinfo.Team;

import java.math.BigDecimal;
import java.util.*;

public class DigitalWallet {

    private static DigitalWallet instance;
    private Map<String, User> users;
    private Map<String, Account> accounts;

    private DigitalWallet(){
        users = new HashMap<>();
        accounts = new HashMap<>();
    }

    public synchronized static DigitalWallet getInstance(){
        if(instance == null){
            instance = new DigitalWallet();
        }
        return instance;
    }

    public void addUser(User user){
        this.users.put(user.getId(), user);
    }

    public void addAccount(Account account){
        this.accounts.put(account.getId(), account);
    }

    public void addPaymentMethod(Account account, PaymentMethod paymentMethod){
        account.addPaymentMethod(paymentMethod);
    }

    public void transferMoney(Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency){

        BigDecimal debitAmount = amount;
        BigDecimal creditAmount = amount;
        if(sourceAccount.getCurrency() != currency){
            debitAmount = CurrencyConvertor.convert(amount, currency, sourceAccount.getCurrency());
        }
        sourceAccount.debitBalance(debitAmount);

        if(destinationAccount.getCurrency() != currency){
            creditAmount = CurrencyConvertor.convert(amount, currency, destinationAccount.getCurrency());
        }
        destinationAccount.creditBalance(creditAmount);

        Transaction transaction = new Transaction(generateTransactionId(), sourceAccount, destinationAccount, amount, currency);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);

    }

    public List<Transaction> getTransactionList(Account account){
        return account.getTransactions();
    }

    private String generateTransactionId(){
        return "TRX-"+ UUID.randomUUID();
    }

}