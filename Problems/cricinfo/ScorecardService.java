package Problems.cricinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ScorecardService {
    private static ScorecardService instance;
    private Map<String, Scorecard> scorecards;
    private AtomicInteger scorecardIdCounter;

    private ScorecardService(){
        scorecards = new ConcurrentHashMap<>();
        this.scorecardIdCounter = new AtomicInteger(0);
    }

    public synchronized static ScorecardService getInstance(){
        if(instance == null){
            instance = new ScorecardService();
        }
        return  instance;
    }


    public Scorecard createScorecard(Match match){
        String scorecardId  = generateScorecardId(match.getId());
        Scorecard scorecard = new Scorecard(scorecardId, match);
        scorecards.put(scorecardId, scorecard);
        return scorecard;
    }

    public void addInnings(String scorecardId, Innings innings){
        Scorecard scorecard = this.scorecards.get(scorecardId);
        if(scorecard != null){
            scorecard.addInnings(innings);
        }
    }

    public void updateScorecard(String scorecardId , String teamId, int score){
        Scorecard scorecard = this.scorecards.get(scorecardId);
        if(scorecard != null){
            scorecard.updateScore(teamId, score);
        }
    }

    public Scorecard getScorecard(String scorecardId){
        return this.scorecards.get(scorecardId);
    }

    private String generateScorecardId(String matchId){
        int scorecardId = scorecardIdCounter.incrementAndGet();
        return "SC-" + matchId + "-" + String.format("%04d", scorecardId);
    }

}