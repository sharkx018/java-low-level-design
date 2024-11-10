package Problems.cricinfo;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private String id;
    private String battingTeamId;
    private String bowlingTeamId;
    private List<Over> overs;

    Innings(String id, String battingTeamId, String bowlingTeamId){
        this.id = id;
        this.battingTeamId = battingTeamId;
        this.bowlingTeamId = bowlingTeamId;
        this.overs = new ArrayList<>();
    }

    public String getBowlingTeamId() {
        return bowlingTeamId;
    }

    public String getId() {
        return id;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public String getBattingTeamId() {
        return battingTeamId;
    }

    public void addOvers(Over over){
        this.overs.add(over);
    }
}