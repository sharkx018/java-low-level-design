package Problems.cricinfo;

import java.util.List;

public class CricketInfo {
    private final MatchService matchService;
    private final ScorecardService scorecardService;

    CricketInfo(){
        matchService = MatchService.getInstance();
        scorecardService = ScorecardService.getInstance();
    }

    public void addMatch(Match match){
        this.matchService.addMatch(match);
    }

    public void updateMatchStatus(Match match, MatchStatus status){
        matchService.updateMatchStatus(match, status);
    }

    public Match getMatch(String matchId){
        return this.matchService.getMatch(matchId);
    }

    public List<Match> getMatchList(){
        return matchService.getAllMatches();
    }


    public Scorecard createScorecard(Match match){
        return this.scorecardService.createScorecard(match);
    }

    public void addInnings(String scorecardId, Innings innings){
        this.scorecardService.addInnings(scorecardId, innings);

    }

    public void updateScore(String scorecardId, String teamId, int score){
        this.scorecardService.updateScorecard(scorecardId, teamId, score);
    }

    public Scorecard getScorecard(String scorecardId){
        return this.scorecardService.getScorecard(scorecardId);
    }

}