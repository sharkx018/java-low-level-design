package Problems.atm;

public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(String transactionId, Account account, int amount){
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        this.account.debit(this.amount);
    }
}