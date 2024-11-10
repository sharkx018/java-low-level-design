package Problems.cricinfo;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private final int overNumber;
    private final List<Ball> balls;

    Over(int overNumber){
        this.overNumber = overNumber;
        this.balls = new ArrayList<>();
    }

    public void addBalls(Ball ball){
        this.balls.add(ball);
    }

    public int getOverNumber() {
        return overNumber;
    }

    public List<Ball> getBalls() {
        return balls;
    }


}