package Problems.chess;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String msg){
        super(msg);
    }
}