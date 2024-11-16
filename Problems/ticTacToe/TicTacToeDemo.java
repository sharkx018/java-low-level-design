package Problems.ticTacToe;

public class TicTacToeDemo {
    public static void main(String[] args) {
        Player p1 = new Player("bot1", 'X');
        Player p2 = new Player("bot2", 'O');

        Game game = new Game(p1, p2);
        game.play();
    }
}
