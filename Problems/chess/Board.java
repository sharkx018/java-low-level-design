package Problems.chess;

import Problems.chess.pieces.*;

public class Board {
    private Piece[][] board;

    public Board(){
        board = new Piece[8][8];
        initBoard();
    }


    public void initBoard(){
        board[0][0] = new Rook(Color.White, 0, 0 );
        board[0][1] = new Knight(Color.White, 0 ,1);;
        board[0][2] = new Bishop(Color.White,0, 2);
        board[0][3] = new Queen(Color.White, 0, 3 );
        board[0][4] = new King(Color.White, 0, 4 );
        board[0][5] = new Bishop(Color.White, 0, 5 );
        board[0][6] = new Knight(Color.White, 0, 6 );
        board[0][7] = new Rook(Color.White, 0, 7 );

        for(int j=0; j<8; j++){
            board[1][j] = new Rook(Color.White, 0, 0 );
        }


        board[7][0] =  new Rook(Color.Black, 7, 0 );
        board[7][1] =  new Knight(Color.Black, 7, 0 );
        board[7][2] =  new Bishop(Color.Black, 7, 2 );
        board[7][3] =  new King(Color.Black, 7, 3 );
        board[7][4] = new Queen(Color.Black, 7, 4);
        board[7][5] =  new Bishop(Color.Black, 7, 5 );
        board[7][6] =  new Knight(Color.Black, 7, 6 );
        board[7][7] =  new Rook(Color.Black, 7, 7 );
        for(int j=0; j<8; j++){
            board[6][j] = new Pawn(Color.Black, 0, 0 );
        }

    }

    public boolean isValidMove(Piece piece, int destRow, int destCol){
        if(destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7){
            return false;
        }

        Piece existingPiece = board[destRow][destCol];

        if(existingPiece != null && existingPiece.getColor() == piece.getColor()){
            return false;
        }

        return piece.canMove(this, destRow, destCol);

    }

    public void setPiece(Piece piece, int row, int col){
        board[row][col] = piece;
    }

    public Piece getPieces(int row, int col) {
        return board[row][col];
    }

    public boolean isCheckMate(Color color){
        //
        return false;

    }

    public boolean isStalemate(Color color){
        return false;
    }

}