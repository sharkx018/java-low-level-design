package Problems.chess.pieces;

import Problems.chess.Board;
import Problems.chess.Color;

public class Rook extends Piece{

    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        return false;
    }
}
