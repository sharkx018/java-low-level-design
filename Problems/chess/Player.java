package Problems.chess;

import Problems.chess.pieces.Piece;

public class Player {
    private final Color color;

    Player(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void makeMove(Board board, Move move){

        Piece piece = move.getPiece();
        int destRow = move.getDestRow();
        int destCol = move.getDestCol();

        if(board.isValidMove(piece, destRow, destCol)){

            board.setPiece(piece, destRow, destCol);
            board.setPiece(null, piece.getRow(), piece.getCol());
            piece.setRow(destRow);
            piece.setCol(destCol);
        }else{
            throw new InvalidMoveException("Invalid move!");
        }

    }

}