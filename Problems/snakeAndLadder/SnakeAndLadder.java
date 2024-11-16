package Problems.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadder {
    private List<Player> players;
    private Board board;
    private Dice dice;
    private int currentPlayerIndex;

    public SnakeAndLadder(List<String > playersStr){

        players = new ArrayList<>();

        for(String playerName: playersStr){
            Player p1 = new Player(playerName);
            players.add(p1);
        }
        board = new Board();
        dice = new Dice();

        currentPlayerIndex = 0;
    }

    public void play(){
        while(!isGameOver()){

            Player player = players.get(currentPlayerIndex);
            int diceNum = dice.roll();

            int currentPosition = player.getPosition();
            int newPosition = currentPosition + diceNum;

            int finalPosition = board.getPositionAfterSnakeOrLadder(newPosition);

            if(newPosition <= board.getBOARD_SIZE()){
                player.setPosition(finalPosition);
                System.out.println(player.getName() + " rolled: "+ diceNum +", got to position: " +finalPosition);
            }


            if(player.getPosition() == board.getBOARD_SIZE()){
                System.out.println("Player "+ player.getName()+" wins");
            }

        }

    }

    private boolean isGameOver(){

        for(Player player : players){
            if(player.getPosition() == board.getBOARD_SIZE()){
                return true;
            }

        }

        return false;

    }


}
