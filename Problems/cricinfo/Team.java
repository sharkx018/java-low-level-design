package Problems.cricinfo;

import java.util.List;

public class Team {
    private String id;
    private String teamName;
    private List<Player> players;

    public Team(String id, String teamName, List<Player> players){
        this.id = id;
        this.teamName = teamName;
        this.players = players;
    }

    public String getId() {
        return id;
    }
}