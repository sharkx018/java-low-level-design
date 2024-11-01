package Problems.atm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void createAccount(String accountNumber, int initialBalance){
        Account account = new Account(accountNumber, initialBalance);
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber){
        return this.accounts.get(accountNumber);
    }

    public void processTransaction(Transaction transaction){
        transaction.execute();
    }

}