package Problems.atm;

public class DepositTransaction extends Transaction {

    DepositTransaction(String transactionId, Account account, int amount){
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        this.account.credit(amount);
    }
}