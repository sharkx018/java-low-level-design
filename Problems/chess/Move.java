package Problems.chess;

import Problems.chess.pieces.Piece;

public class Move {
    private final Piece piece;
    private final int destRow;
    private final int destCol;

    public Move(Piece piece, int row, int col){
        this.piece = piece;
        this.destRow = row;
        this.destCol = col;
    }


    public int getDestCol() {
        return destCol;
    }

    public int getDestRow() {
        return destRow;
    }

    public Piece getPiece() {
        return piece;
    }

}