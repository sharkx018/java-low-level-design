package Problems.atm;

public class AtmDemo {

    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(1000);

        Atm atm = new Atm(bankingService, cashDispenser);

        // Create accounts
        String accountNum1 = "1234";
        String accountNum2 = "7768";
        bankingService.createAccount(accountNum1, 300);
        bankingService.createAccount(accountNum2, 500);

        //Perform ATM operations
        Card card = new Card("xyz", "455");
        atm.authenticateCard(card, "455");

        int balance = atm.checkBalance(accountNum1);
        System.out.println("Account Balance: " + balance);

        atm.creditMoney(accountNum1, 100);
        balance = atm.checkBalance(accountNum1);
        System.out.println("Account Balance: " + balance);

        atm.withdrawMoney(accountNum2, 50);
        balance = atm.checkBalance(accountNum2);
        System.out.println("Account Balance: " + balance);

    }

}