package Problems.chess.pieces;

import Problems.chess.Board;
import Problems.chess.Color;

public class Queen extends Piece {
    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        return false;
    }
}