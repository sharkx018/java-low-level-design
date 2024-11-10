package Problems.cricinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MatchService {
    private static MatchService instance;
    private ConcurrentHashMap<String, Match> matchListMap;

    private MatchService(){
        matchListMap = new ConcurrentHashMap<>();
    }


    public static synchronized MatchService getInstance(){
        if(instance == null){
            instance = new MatchService();
        }

        return instance;
    }

    public void addMatch(Match match){
        this.matchListMap.put(match.getId(), match);
    }

    public Match getMatch(String matchId){
        return this.matchListMap.get(matchId);
    }

    public List<Match> getAllMatches(){
        return new ArrayList<>(matchListMap.values());
    }

    public void updateMatchStatus(Match matcha, MatchStatus matchStatus){
        Match match =  this.matchListMap.get(matcha.getId());
        if(match!= null){
            match.setStatus(matchStatus);
            System.out.println("Match: " + match.getTitle() + " , status changed to : " + matchStatus);
        }
    }
}