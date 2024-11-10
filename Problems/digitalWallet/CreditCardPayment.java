package Problems.digitalWallet;

import java.math.BigDecimal;

public class CreditCardPayment extends PaymentMethod{
    private String creditCardNumber;
    private String cardHolderName;
    private String expiry;

    public CreditCardPayment(String id, String type, String creditCardNumber, String cardHolderName, String expiry){
        super(id, type);
        this.creditCardNumber = creditCardNumber;
        this.cardHolderName = cardHolderName;
        this.expiry = expiry;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        return true;
    }

}