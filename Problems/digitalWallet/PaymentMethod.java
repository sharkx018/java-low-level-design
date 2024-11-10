package Problems.digitalWallet;

import java.math.BigDecimal;

abstract class PaymentMethod {

    private String id;
    private String type;

    public PaymentMethod(String id, String type){
        this.id = id;
        this.type = type;
    }

    public String getId(){
        return this.id;
    }

    public String getType() {
        return type;
    }

    public abstract boolean processPayment(BigDecimal amount);
}