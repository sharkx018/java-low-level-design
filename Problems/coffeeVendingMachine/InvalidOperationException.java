package Problems.coffeeVendingMachine;

public class InvalidOperationException extends RuntimeException{
    public InvalidOperationException(String message){
        super(message);
    }
}