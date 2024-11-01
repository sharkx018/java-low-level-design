package Problems.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class Atm {
    private BankingService bankingService;
    private CashDispenser cashDispenser;
    private static final AtomicLong transactionCounter = new AtomicLong(0);

    public Atm(BankingService bankingService, CashDispenser cashDispenser){
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public boolean authenticateCard(Card card, String pin){
        return true;
    }

    public int checkBalance(String accountNumber){
        return bankingService.getAccount(accountNumber).getAmount();
    }

    public void creditMoney(String accountNumber, int amount){
        Account account = bankingService.getAccount(accountNumber);
        DepositTransaction depositTransaction = new DepositTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(depositTransaction);
    }

    public void withdrawMoney(String accountNumber, int amount){
        Account account = bankingService.getAccount(accountNumber);
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(withdrawalTransaction);
        cashDispenser.dispenseCash(amount);
    }

    private String generateTransactionId(){
        long transactionNumber = transactionCounter.incrementAndGet();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TRN" + time + String.format("%010d", transactionNumber);
    }


}