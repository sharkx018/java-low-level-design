package Problems.ticTacToe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;


    Game(Player player1, Player player2){
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void play(){
        board.printBoard();

        while(!board.hasWinner() && !board.isFull()){
            System.out.println(currentPlayer.getName()+ "'s turn.");

            int row = getValidInput("Enter the row (0-2)");
            int col = getValidInput("Enter the col (0-2)");

            try {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                switchPlayer();
            }catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }

        if(board.hasWinner()){
            switchPlayer();
            System.out.println(currentPlayer.getName() + " wins!");
        }else{
            System.out.println("Its a draw");
        }
    }

    private void switchPlayer(){
//        if(currentPlayer == player1){
//            currentPlayer = player2;
//        }else{
//            currentPlayer = player1;
//        }

        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private int getValidInput(String message){
        Scanner scanner = new Scanner(System.in);
        int input;

        while(true){
            System.out.println(message);
            if(scanner.hasNextInt()){
                input = scanner.nextInt();
                if(input >= 0 && input <3){
                    return input;
                }
            }else{
                scanner.next();
            }
            System.out.println("Invalid input! Please input the number between 0 to 2.");
        }

    }

}
