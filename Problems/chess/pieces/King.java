package Problems.chess.pieces;

import Problems.chess.Board;
import Problems.chess.Color;


public class King extends Piece {

    public King(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = Math.abs(row - destRow);
        int colDiff = Math.abs(col - destCol);

        if(rowDiff >1 || colDiff >1){
            return false;
        }

        return true;
    }
}