package Problems.snakeAndLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        List<String > p1 = Arrays.asList("Player 1", "Player 2");
        gameManager.startNewGame(p1);

    }
}
