package Problems.digitalWallet;

public class InsufficientFundException extends RuntimeException{
    InsufficientFundException(String msg){
        super(msg);
    }
}