package Problems.digitalWallet;

import java.math.BigDecimal;

public class NetBanking extends PaymentMethod {

    private String userID;
    private String password;

    public NetBanking(String id, String type, String userID, String password){
        super(id, type);
        this.userID = userID;
        this.password = password;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        return true;
    }
}