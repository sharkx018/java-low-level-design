package Problems.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance;
    private List<SnakeAndLadder> games;

    private GameManager(){
        this.games = new ArrayList<>();
    }

    public static synchronized GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }

        return instance;
    }

    public void startNewGame(List<String > players){
        SnakeAndLadder game = new SnakeAndLadder(players);
        this.games.add(game);
        new Thread(()->game.play()).start();
    }
}
