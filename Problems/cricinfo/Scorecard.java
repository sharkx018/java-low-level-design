package Problems.cricinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scorecard {
    private String id;
    private Match match;
    private List<Innings> innings;
    private Map<String , Integer> teamScore;

    Scorecard(String  id, Match match){
        this.id = id;
        this.match = match;
        teamScore = new HashMap<>();
        this.innings = new ArrayList<>();
    }

    public void updateScore(String teamId, int score){
        this.teamScore.put(teamId, score);
    }

    public void addInnings(Innings innings){
        this.innings.add(innings);
    }

    public String getId() {
        return id;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    public Map<String, Integer> getTeamScore() {
        return teamScore;
    }

    public Match getMatch() {
        return match;
    }
}