package Problems.digitalWallet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private Account sourceAccount;
    private Account destinatonAccount;
    private BigDecimal amount;
    private Currency currency;
    private LocalDateTime timestamp;

    public Transaction(String id, Account sourceAccount, Account destinatonAccount, BigDecimal amount, Currency currency){
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinatonAccount = destinatonAccount;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Account getDestinatonAccount() {
        return destinatonAccount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }


}