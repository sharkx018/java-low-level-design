package Problems.chess.pieces;

import Problems.chess.Board;
import Problems.chess.Color;

public abstract class Piece {
    protected int row;
    protected int col;
    protected Color color;

    public Piece(Color color, int row, int col){
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public Color getColor(){
        return this.color;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public abstract boolean canMove(Board board, int x, int y);

}