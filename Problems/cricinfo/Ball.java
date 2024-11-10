package Problems.cricinfo;

public class Ball {
    private final int ballNumber;
    private final String batsman;
    private final String bowler;
    private final String result;

    Ball(int ballNumber, String batsman, String bowler, String result){
        this.ballNumber = ballNumber;
        this.batsman = batsman;
        this.bowler = bowler;
        this.result = result;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public String getBatsman() {
        return batsman;
    }

    public String getBowler() {
        return bowler;
    }

    public String getResult() {
        return result;
    }


}