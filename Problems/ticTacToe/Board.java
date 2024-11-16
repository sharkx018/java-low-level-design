package Problems.ticTacToe;

public class Board {
    private char[][] grid;
    private int movesCount;

    Board(){
        this.grid = new char[3][3];
        initBoard();
    }

    private void initBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.grid[i][j] = '-';
            }
        }
        movesCount = 0;
    }



    public void makeMove(int row, int col, char symbol){
        if(row < 0 || row >=3 || col <0 || col >=3 || this.grid[row][col] != '-'){
            throw new IllegalArgumentException("Invalid move");
        }

        this.grid[row][col] = symbol;
        movesCount ++;
    }

    public void printBoard(){

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(this.grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean isFull(){
        return  movesCount == 9;
    }

    public boolean hasWinner(){

        // check rows
        for(int i=0; i<3; i++){
            if(this.grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]){
                return  true;
            }
        }

        // check col
        for(int j=0; j<3; j++){
            if(this.grid[0][j] != '-' && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]){
                return  true;
            }
        }

        if(grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
            return true;
        }

        if(grid[0][2] != '-'  && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]){
            return true;
        }

        return false;
    }

}
