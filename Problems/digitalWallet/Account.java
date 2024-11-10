package Problems.digitalWallet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
    private String id;
    private String accountNumber;
    private BigDecimal balance;
    private User user;
    private Currency currency;
    private List<Transaction> transactions;
    private Map<String ,PaymentMethod> paymentMethods;


    public Account(String id, String accountNumber, User user, Currency currency){
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.user = user;
        this.currency = currency;
        transactions = new ArrayList<>();
        this.paymentMethods = new HashMap<>();
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public void removePaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethods.remove(paymentMethod.getId());
    }


    public PaymentMethod getPaymentMethod(String id){
        return this.paymentMethods.get(id);
    }


    public void creditBalance(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void debitBalance(BigDecimal amount){
        if(balance.compareTo(amount) >= 0){
            this.balance = this.balance.subtract(amount);
        }else{
            throw new InsufficientFundException("Insufficient funds in the account");
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Map<String, PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}

