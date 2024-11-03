package Problems.chess;

import Problems.chess.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Player[] players;
    private int currentPlayer;


    public ChessGame(){
        board = new Board();
        players = new Player[]{new Player(Color.White), new Player(Color.Black)};
        currentPlayer = 0;
    }

    public void startGame(){

        while(!isGameOver()){

            Player player = players[currentPlayer];
            System.out.println("Player " + player.getColor() + " turn" );

            try {
                Move move = getInputMove(player);

                player.makeMove(board, move);

            }catch (InvalidMoveException error){
                System.out.println(error.getMessage());
                System.out.println("Try Again!");
                continue;
            }

            currentPlayer = (currentPlayer + 1)%2;
        }

        showResult();
    }

    private Move getInputMove(Player player){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the source row:");
        int sourceRow = scanner.nextInt();

        System.out.println("Enter the source col:");
        int sourceCol = scanner.nextInt();

        System.out.println("Enter the destination row:");
        int destRow = scanner.nextInt();

        System.out.println("Enter the destination col:");
        int destCol = scanner.nextInt();

        Piece piece = board.getPieces(sourceRow, sourceCol);
        if(piece == null || piece.getColor() != player.getColor()){
            throw new InvalidMoveException("Invalid Selection");
        }

        return new Move(piece, destRow, destCol);
    }

    private boolean isGameOver(){
        return (
                board.isCheckMate(Color.White) ||
                board.isCheckMate(Color.Black) ||
                board.isStalemate(Color.White) ||
                board.isStalemate(Color.Black)
               );

    }

    private void showResult(){


        if(board.isCheckMate(Color.Black)){
            System.out.println("Player " + Color.Black + " wins!");
        }else if(board.isCheckMate(Color.White)){
            System.out.println("Player "+Color.White + " wins!");
        }else if(board.isStalemate(Color.Black) || board.isStalemate(Color.White)){
            System.out.println("The game ends in a stalemate!");
        }

    }



}